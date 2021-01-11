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

	MLAnonimizedSummary(String theCountry){
		country = theCountry;
	}

	MLAnonimizedSummary(String theCountry, String theRegion){
		country = theCountry;
		region = theRegion;
	}

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