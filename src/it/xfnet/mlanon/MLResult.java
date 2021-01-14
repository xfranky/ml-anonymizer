package it.xfnet.mlanon;

/**
* Class representing a result to be added to the anonymizer, with all its components
*/
public class MLResult {
	long speed;
	String country;
	String region;
	String isp;
	int asn;

	/**
	* Constructor for the result objects to be fed to the anonymizer
	* @param theSpeed the data transfer speed recorded for this result
	* @param theCountry the country the connection came from
	* @param theRegion the region in the country the connection came from
	* @param theIsp the name of the IPS the connection came from
	* @param theAsn the Autonomous System Number the connection came from
	*/
	public MLResult(long theSpeed, String theCountry, String theRegion, String theIsp, int theAsn){
		speed = theSpeed;
		country = theCountry;
		region = theRegion;
		isp = theIsp;
		asn = theAsn;
	}

	/**
	* Method to get the country recorded in this result
	* @return the country of the result 
	*/
	public String getCountry() {
		return country;
	}

	/**
	* Method to get the region recorded in this result
	* @return the region of the result 
	*/
	public String getRegion() {
		return region;
	}

	/**
	* Method to get the ISP recorded in this result
	* @return the ISP of the result 
	*/
	public String getIsp() {
		return isp;
	}

	/**
	* Method to get the Autonomous System Number recorded in this result
	* @return the ASN of the result 
	*/
	public int getAsn() {
		return asn;
	}

	/**
	* Method to get the transfer speed recorded in this result
	* @return the transfer speed of the result 
	*/
	public long getSpeed() {
		return speed;
	}
}