package it.xfnet.mlanon;

public class MultiLevelAnonimizer {

	private int defaultMinResults;
	private java.util.HashMap<String, MLCountry> countries;
	private int totResults;

	/**
	* Constructor building a MultiLevelAnonimizer object, with the possibility to customize
	* the number of results needed in order to consider a summary to be anonymous.
	* @param minResultsInit the minimum number of results to use in order to consider a summary as anonymous.
	* @return the new MultiLevelAnonimizer with an empty result set
	*/
	public MultiLevelAnonimizer(int minResultsInit){
		defaultMinResults = minResultsInit;
		countries = new java.util.HashMap<String, MLCountry>();
		totResults = 0;
	}

	/**
	* Default constructor setting the default minimum number of results for a summary as 2
	* @return the new MultiLevelAnonimizer with an empty result set
	*/
	public MultiLevelAnonimizer() {
		this(2);
	}

	/**
	* Method to add a result to the set of results to be anonimized
	* @param result the result to add
	*/
	public void addResult(MLResult result) {
		// System.out.println("Adding result to country: " + result.getCountry());
		if (!countries.containsKey(result.getCountry())) {
			countries.put(result.getCountry(), new MLCountry(result.getCountry()));
			System.out.println("Added country: " + result.getCountry());
		}
		countries.get(result.getCountry()).addResult(result);
		totResults++;
	}

	public String toString() {
		return "Countries: " + String.valueOf(countries.size());
	}

	/**
	* Returns the number of different countries present in the results
	* @return the number of countries with results in this anonimizer
	*/
	public int numCountries() {
		return countries.size();
	}

	public int numRegions() {
		int regionCount = 0;
		for(MLCountry country : countries.values()) {
			regionCount += country.numRegions();
		}
		return regionCount;
	}

	public int numIsps() {
		int ispCount = 0;
		for(MLCountry country : countries.values()) {
			ispCount += country.getNumIsps();
		}
		return ispCount;
	}

	public int getNumResults() {
		return totResults;
	}

	java.util.List<MLAnonimizedSummary> getAnonimizedResults() {
		return getAnonimizedResults(defaultMinResults);
	}

	public java.util.List<MLAnonimizedSummary> getAnonimizedResults(int minResults) {
		// Let's keep the anonimized summaries in a list
		java.util.List<MLAnonimizedSummary> summaries = new java.util.ArrayList<MLAnonimizedSummary>();
		MLAnonimizedSummary currentSummary;
		for(MLCountry country : countries.values()) {
			// if(country.getNumResults() >= minResults) {
			// 	currentSummary = new MLAnonimizedSummary(country.getCountryName());
			// 	country.populateSummaries(summaries, currentSummary, minResults);
			// 	summaries.add(currentSummary);
			// }
			country.addAnonimizedResults(summaries, minResults);
		}
		return summaries;
	}
}