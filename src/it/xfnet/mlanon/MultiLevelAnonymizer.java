package it.xfnet.mlanon;

public class MultiLevelAnonymizer {

	private int defaultMinResults;
	private java.util.HashMap<String, MLCountry> countries;
	private int totResults;
	private int verbosity;

	/**
	* Constructor building a MultiLevelAnonymizer object, with the possibility to customize
	* the number of results needed in order to consider a summary to be anonymous. By
	* default verbosity is turned off.
	* @param minResultsInit the minimum number of results to use in order to consider a summary as anonymous.
	*/
	public MultiLevelAnonymizer(int minResultsInit){
		this(minResultsInit, 0);
	}

	/**
	* Constructor building a MultiLevelAnonymizer object, with the possibility to customize
	* the number of results needed in order to consider a summary to be anonymous and
	* the verbosity for debug purposes
	* @param minResultsInit the minimum number of results to use in order to consider a summary as anonymous.
	* @param theVerbosity the verbosity level for debug purposes, between 0 (off) and 3
	*/
	public MultiLevelAnonymizer(int minResultsInit, int theVerbosity){
		defaultMinResults = minResultsInit;
		countries = new java.util.HashMap<String, MLCountry>();
		totResults = 0;
		verbosity = theVerbosity;
	}

	/**
	* Default constructor setting the default minimum number of results for a summary as 2
	*/
	public MultiLevelAnonymizer() {
		this(2);
	}

	/**
	* Method to add a result to the set of results to be anonymized
	* @param result the result to add
	*/
	public void addResult(MLResult result) {
		if (verbosity > 2) {
			System.out.println("Adding result to country: " + result.getCountry());
		}
		if (!countries.containsKey(result.getCountry())) {
			countries.put(result.getCountry(), new MLCountry(result.getCountry()));
			if (verbosity > 1) {
				System.out.println("Added country: " + result.getCountry());
			}
		}
		countries.get(result.getCountry()).addResult(result);
		totResults++;
	}

	public String toString() {
		return "Countries: " + String.valueOf(countries.size());
	}

	/**
	* Returns the number of different countries present in the collected results
	* @return the number of countries with results in this anonymizer
	*/
	public int numCountries() {
		return countries.size();
	}

	/**
	* Returns the total number of regions present in the collected results
	* @return the number of regions with results in this anonymizer
	*/
	public int numRegions() {
		int regionCount = 0;
		for(MLCountry country : countries.values()) {
			regionCount += country.numRegions();
		}
		return regionCount;
	}

	/**
	* Returns the total number of ISPs present in the collected results
	* @return the number of ISPs with results in this anonymizer
	*/
	public int numIsps() {
		int ispCount = 0;
		for(MLCountry country : countries.values()) {
			ispCount += country.getNumIsps();
		}
		return ispCount;
	}

	/**
	* Returns the total number of results collected
	* @return the number of results in this anonymizer
	*/
	public int getNumResults() {
		return totResults;
	}

	java.util.List<MLAnonymizedSummary> getAnonymizedResults() {
		return getAnonymizedResults(defaultMinResults);
	}

	public java.util.List<MLAnonymizedSummary> getAnonymizedResults(int minResults) {
		// Let's keep the anonymized summaries in a list; will be filled and scanned
		// in order so there is no need for fancy data structures
		java.util.List<MLAnonymizedSummary> summaries = new java.util.ArrayList<MLAnonymizedSummary>();
		for(MLCountry country : countries.values()) {
			country.addAnonymizedResults(summaries, minResults);
		}
		return summaries;
	}
}