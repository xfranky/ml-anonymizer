package it.xfnet.mlanon;

public class MLResult {
	long speed;
	String country;
	String region;
	String isp;
	int asn;

	public MLResult(long theSpeed, String theCountry, String theRegion, String theIsp, int theAsn){
		speed = theSpeed;
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

	long getSpeed() {
		return speed;
	}
}