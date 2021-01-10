package it.xfnet.mlanon;

class MLCountry {
	java.util.HashMap<String, MLRegion> regions;
	int numResults;
	String country;

	MLCountry(String theCountry) {
		regions = new java.util.HashMap<String, MLRegion>();
		numResults = 0;
		country = theCountry;
	}

	String getCountryName() {
		return country;
	}

	void addResult(MLResult result) {
		// System.out.println("Adding result to region: " + result.getRegion());
		// If I don't have a region with that name already, I add it
		if(!regions.containsKey(result.getRegion())) {
			regions.put(result.getRegion(), new MLRegion(result.getRegion(),this));
			System.out.println("Added region: " + result.getRegion());
		}
		// At this point I should have a relevant region, so let's percolate the result
		regions.get(result.getRegion()).addResult(result);
		// Not sure I really need this in the end but to keep it updated
		numResults++;
	}

	int numRegions() {
		return regions.size();
	}

	public int getNumIsps() {
		int ispCount = 0;
		for(MLRegion region : regions.values()) {
			ispCount += region.getNumIsps();
		}
		return ispCount;
	}

	static int getNumResults(java.util.Collection<MLRegion> regionsList) {
		if (regionsList.size() == 0) {
			// Do I need to actually do this or the for supports empty lists???
			return 0;
		}
		int numResults = 0;
		for (MLRegion region : regionsList) {
			numResults += region.getNumResults();
		}
		return numResults;
	}

	int getNumResults() {
		return numResults;
	}

	Double getAverageSpeed() {
		return getAverageSpeed(regions.values());
	}

	static Double getAverageSpeed(java.util.Collection<MLRegion> regionsList) {
		if (regionsList.size() == 0){
			return null;
		}
		Double averageSpeed = 0.0;
		int averageResults = 0;
		double regionAverageSpeed = 0.0;
		int regionNumResults = 0;
		// Bravely trying to iteratively calculate the average without summing all the values
		for (MLRegion region : regionsList) {
			regionAverageSpeed = region.getAverageSpeed();
			regionNumResults = region.getNumResults();
			averageSpeed = (regionAverageSpeed / (averageResults + regionNumResults) * regionNumResults)
				+ (averageSpeed / (averageResults + regionNumResults) * averageResults);
			averageResults += regionNumResults;
		}
		return averageSpeed;
	}

	Long getMaxSpeed() {
		return getMaxSpeed(regions.values());
	}

	static Long getMaxSpeed(java.util.Collection<MLRegion> regionsList) {
		if (regionsList.size() == 0) {
			return null;
		}
		Long maxSpeed = 0L;
		long regionMaxSpeed = 0L;
		for (MLRegion region : regionsList) {
			regionMaxSpeed = region.getMaxSpeed();
			if (regionMaxSpeed > maxSpeed) {
				maxSpeed = regionMaxSpeed;
			}
		}
		return maxSpeed;
	}

	void addAnonimizedResults(java.util.List<MLAnonimizedSummary> summaries, int minResults) {
		java.util.List<MLRegion> extraRegions = new java.util.LinkedList<MLRegion>();
		MLAnonimizedSummary currentSummary;
		for(MLRegion region : regions.values()) {
			if (region.getNumResults() < minResults) {
				extraRegions.add(region);
				// System.out.println("Extra ASNs: " + extraAsns.size());
			} else {
				region.addAnonimizedResults(summaries, minResults);
			}
		}
		if (getNumResults(extraRegions) >= minResults) {
			currentSummary = new MLAnonimizedSummary(country, null, null, null);
			currentSummary.setNumResults(getNumResults(extraRegions)); // TODO add implementation to get number results from a list
			currentSummary.setMaxSpeed(getMaxSpeed(extraRegions));
			currentSummary.setAvgSpeed(getAverageSpeed(extraRegions));
			summaries.add(currentSummary);
		}
	}

	void populateSummaries(java.util.List<MLAnonimizedSummary> summaries, MLAnonimizedSummary currentSummary, int minResults) {
		MLAnonimizedSummary regionSummary;
		for(MLRegion region : regions.values()) {
			if (region.getNumResults() >= minResults) {
				regionSummary = new MLAnonimizedSummary(currentSummary.getCountry(), region.getRegionName());
				// Percolate here
				summaries.add(regionSummary);
			}
		}
	}

}