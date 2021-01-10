package it.xfnet.mlanon;

class MLAsn {
	java.util.List<MLResult> results;
	int thisAsn;
	MLIsp thisIsp;

	MLAsn(int theAsn, MLIsp theIsp) {
		results = new java.util.LinkedList<MLResult>();
		thisAsn = theAsn;
		thisIsp = theIsp;
	}

	void addResult(MLResult result) {
		results.add(result);
	}

	Double getAverageSpeed() {
		// If I don't have results don't return a number
		if (results.size() == 0) {
			return null;
		}
		long speedSum = 0;
		for(MLResult result : results){
			speedSum += result.getSpeed();
		}
		return (double)speedSum/(results.size());
	}

	Long getMaxSpeed() {
		if (results.size() == 0){
			return null;
		}
		long maxSpeed = 0;
		for (MLResult result : results){
			if (result.getSpeed() > maxSpeed){
				maxSpeed = result.getSpeed();
			}
		}
		return maxSpeed;
	}

	int getNumResults() {
		return results.size();
	}

	int getASNumber() {
		return thisAsn;
	}

	MLIsp getIsp() {
		return thisIsp;
	}

	MLRegion getRegion() {
		return thisIsp.getRegion();
	}

	MLCountry getCountry() {
		return thisIsp.getCountry();
	}

}