package it.xfnet.mlanon;

public class MultiLevelAnonimizer {

	private int defaultMinResults;
	private java.util.HashMap<String, MLCountry> countries;
	private int totResults;

	public MultiLevelAnonimizer(int minResultsInit){
		defaultMinResults = minResultsInit;
		countries = new java.util.HashMap<String, MLCountry>();
		totResults = 0;
	}

	public MultiLevelAnonimizer() {
		this(2);
	}

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