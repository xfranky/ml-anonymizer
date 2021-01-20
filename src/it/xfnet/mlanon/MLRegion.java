package it.xfnet.mlanon;

class MLRegion {
	java.util.HashMap<String, MLIsp> isps;
	int numResults;
	String region;
	MLCountry thisCountry;

	MLRegion(String theRegion, MLCountry theCountry) {
		isps = new java.util.HashMap<String, MLIsp>();
		numResults = 0;
		region = theRegion;
		thisCountry = theCountry;
	}

	void addResult(MLResult result) {
		// System.out.println("Adding result to ISP: " + result.getIsp());
		// If I don't have an ISP with that name already, I add it
		if(!isps.containsKey(result.getIsp())) {
			isps.put(result.getIsp(), new MLIsp(result.getIsp(),this));
			// System.out.println("Added ISP: " + result.getIsp());
		}
		// At this point I should have a relevant region, so let's percolate the result
		isps.get(result.getIsp()).addResult(result);
		// Not sure I really need this in the end but it's a good idea to keep it updated
		numResults++;
	}

	int getNumIsps() {
		return isps.size();
	}

	int getNumResults() {
		return numResults;
	}

	static int getNumResults(java.util.Collection<MLIsp> ispsList) {
		if (ispsList.size() == 0) {
			// Do I need to actually do this or the for supports empty lists???
			return 0;
		}
		int numResults = 0;
		for (MLIsp isp : ispsList) {
			numResults += isp.getNumResults();
		}
		return numResults;
	}

	String getRegionName() {
		return region;
	}

	Double getAverageSpeed() {
		return getAverageSpeed(isps.values());
	}

	static Double getAverageSpeed(java.util.Collection<MLIsp> ispsList) {
		if (ispsList.size() == 0){
			return null;
		}
		Double averageSpeed = 0.0;
		int averageResults = 0;
		// Bravely trying to iteratively calculate the average without summing all the values
		for (MLIsp isp : ispsList) {
			averageSpeed = (isp.getAverageSpeed() / (averageResults + isp.getNumResults()) * isp.getNumResults())
				+ (averageSpeed / (averageResults + isp.getNumResults()) * averageResults);
			averageResults += isp.getNumResults();
		}
		return averageSpeed;
	}

	Long getMaxSpeed() {
		return getMaxSpeed(isps.values());
	}

	static Long getMaxSpeed(java.util.Collection<MLIsp> ispsList) {
		if (ispsList.size() == 0) {
			return null;
		}
		Long maxSpeed = 0L;
		for (MLIsp isp : ispsList) {
			if (isp.getMaxSpeed() > maxSpeed) {
				maxSpeed = isp.getMaxSpeed();
			}
		}
		return maxSpeed;
	}

	MLCountry getCountry() {
		return thisCountry;
	}

	void addAnonymizedResults(java.util.List<MLAnonymizedSummary> summaries, int minResults) {
		java.util.List<MLIsp> extraIsps = new java.util.LinkedList<MLIsp>();
		MLAnonymizedSummary currentSummary;
		for(MLIsp isp : isps.values()) {
			if (isp.getNumResults() < minResults) {
				extraIsps.add(isp);
				// System.out.println("Extra ASNs: " + extraAsns.size());
			} else {
				isp.addAnonymizedResults(summaries, minResults);
			}
		}
		if (getNumResults(extraIsps) >= minResults) {
			currentSummary = new MLAnonymizedSummary(thisCountry.getCountryName(),
				region, null, null);
			currentSummary.setNumResults(getNumResults(extraIsps)); // TODO add implementation to get number results from a list
			currentSummary.setMaxSpeed(getMaxSpeed(extraIsps));
			currentSummary.setAvgSpeed(getAverageSpeed(extraIsps));
			summaries.add(currentSummary);
		}
	}

}