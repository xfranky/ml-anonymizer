package it.xfnet.mlanon;

import java.util.List;

public class MLResultLoaderTest {
	public static void main(String[] args) {
		String fileName = "test.csv";
		int minResults = 2;
		if (args.length > 0) {
			fileName = args[0];
			if (args.length > 1) {
				minResults = Integer.parseInt(args[1]);
			}
		}
		MultiLevelAnonimizer mla = new MultiLevelAnonimizer();

		System.out.println("Loading file: " + fileName);
		MLResultLoader.loadResultCsv(fileName, mla);

		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		List<MLAnonimizedSummary> summaries = mla.getAnonimizedResults(minResults);
		for(MLAnonimizedSummary summary : summaries) {
			System.out.println(summary);
		}
	}
}