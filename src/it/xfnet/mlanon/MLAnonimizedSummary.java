package it.xfnet.mlanon;

/**
* This class represents an anonymized summary of records with all the properties that could be anonymized
*/
class MLAnonimizedSummary {
	String country;
	String region;
	String isp;
	Integer asn;

	int numResults;
	long maxSpeed;
	double avgSpeed;

	/**
	* Main constructor, with all levels. Use null when the level didn't have enough data to
	* be anonymized. For now the aggregated data (average and max speed) have to be set separately
	* to avoid too many parameters in the constructor; this might be changed later adding a new
	* constructor if deemed proper.
	*
	* @param theCountry a String with the ISO code of the country
	* @param theRegion	a String with the name of the region
	* @param theIsp		a String with the name of the ISP
	* @param theAsn		an Integer with the autonomous system number
	* @return the summary object
	*/
	MLAnonimizedSummary(String theCountry, String theRegion, String theIsp, Integer theAsn){
		country = theCountry;
		region = theRegion;
		isp = theIsp;
		asn = theAsn;
	}

	String getCountry() {
		return country;
	}

	String getRegion() {
		return region;
	}

	String getIsp() {
		return isp;
	}

	int getAsn() {
		return asn;
	}

	void setCountry(String theCountry) {
		country = theCountry;
	}

	void setRegion(String theRegion) {
		region = theRegion;
	}

	void setNumResults(int theResults) {
		numResults = theResults;
	}

	void setMaxSpeed(long theMaxSpeed){
		maxSpeed = theMaxSpeed;
	}

	void setAvgSpeed(double theAvgspeed) {
		avgSpeed = theAvgspeed;
	}

	public String toString() {
		return country + "|" + region + "|" + isp + "|" + asn + "|" + numResults + "|" + maxSpeed + "|" + avgSpeed;
	}
}