package it.xfnet.mlanon;

class MLIsp {
	java.util.HashMap<Integer, MLAsn> asns;
	int numResults;
	String isp;
	MLRegion thisRegion;

	MLIsp(String theIsp, MLRegion theRegion) {
		asns = new java.util.HashMap<Integer, MLAsn>();
		numResults = 0;
		isp = theIsp;
		thisRegion = theRegion;
	}

	void addResult(MLResult result) {
		// System.out.println("Adding result to ASN: " + result.getAsn());
		// If I don't have such an AS already, I add it
		if(!asns.containsKey(result.getAsn())) {
			asns.put(result.getAsn(), new MLAsn(result.getAsn(),this));
			System.out.println("Added ASN: " + result.getAsn());
		}
		// At this point I should have a relevant region, so let's percolate the result
		asns.get(result.getAsn()).addResult(result);
		// Not sure I really need this in the end but to keep it updated
		numResults++;
	}

	static Double getAverageSpeed(java.util.Collection<MLAsn> asnsList) {
		if (asnsList.size() == 0){
			return null;
		}
		Double averageSpeed = 0.0;
		int averageResults = 0;
		// Bravely trying to iteratively calculate the average without summing all the values
		for (MLAsn asn : asnsList) {
			averageSpeed = (asn.getAverageSpeed() / (averageResults + asn.getNumResults()) * asn.getNumResults())
				+ (averageSpeed / (averageResults + asn.getNumResults()) * averageResults);
			averageResults += asn.getNumResults();
		}
		return averageSpeed;
	}

	Double getAverageSpeed() {
		return getAverageSpeed(asns.values());
	}

	static Long getMaxSpeed(java.util.Collection<MLAsn> asnsList) {
		if (asnsList.size() == 0) {
			return null;
		}
		Long maxSpeed = 0L;
		for (MLAsn asn : asnsList) {
			if (asn.getMaxSpeed() > maxSpeed) {
				maxSpeed = asn.getMaxSpeed();
			}
		}
		return maxSpeed;
	}

	Long getMaxSpeed() {
		return getMaxSpeed(asns.values());
	}

	static int getNumResults(java.util.Collection<MLAsn> asnsList) {
		if (asnsList.size() == 0) {
			// Do I need to actually do this or the for supports empty lists???
			return 0;
		}
		int numResults = 0;
		for (MLAsn asn : asnsList) {
			numResults += asn.getNumResults();
		}
		return numResults;
	}

	void addAnonimizedResults(java.util.List<MLAnonimizedSummary> summaries, int minResults) {
		java.util.List<MLAsn> extraAsns = new java.util.LinkedList<MLAsn>();
		MLAnonimizedSummary currentSummary;
		for(MLAsn asn : asns.values()) {
			if (asn.getNumResults() < minResults) {
				extraAsns.add(asn);
				// System.out.println("Extra ASNs: " + extraAsns.size());
			} else {
				currentSummary = new MLAnonimizedSummary(thisRegion.getCountry().getCountryName(),
					thisRegion.getRegionName(), isp, asn.getASNumber());
				currentSummary.setNumResults(asn.getNumResults());
				currentSummary.setMaxSpeed(asn.getMaxSpeed());
				currentSummary.setAvgSpeed(asn.getAverageSpeed());
				summaries.add(currentSummary);
			}
		}
		if (getNumResults(extraAsns) >= minResults) {
			currentSummary = new MLAnonimizedSummary(thisRegion.getCountry().getCountryName(),
				thisRegion.getRegionName(), isp, null);
			currentSummary.setNumResults(getNumResults(extraAsns)); // TODO add implementation to get number results from a list
			currentSummary.setMaxSpeed(getMaxSpeed(extraAsns));
			currentSummary.setAvgSpeed(getAverageSpeed(extraAsns));
			summaries.add(currentSummary);
		}
	}

	int getNumResults() {
		return numResults;
	}

	MLRegion getRegion() {
		return thisRegion;
	}

	MLCountry getCountry() {
		return thisRegion.getCountry();
	}
}