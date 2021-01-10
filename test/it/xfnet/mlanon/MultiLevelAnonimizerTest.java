package it.xfnet.mlanon;

import java.util.List;

public class MultiLevelAnonimizerTest {
	
	/***
	* This class will test the Multi Level Anonimizer
	*/

	public static void main(String[] args) {
		int minResults = 2;
		if (args.length > 0) {
			minResults = Integer.parseInt(args[0]);
		}
		System.out.println("hii!!");
		MultiLevelAnonimizer mla = new MultiLevelAnonimizer();
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		MLResult r1 = new MLResult(100,"HK","Kowloon","HKBN",9269);
		mla.addResult(r1);
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		MLResult r2 = new MLResult(150,"HK","Kowloon","Smartone",9213);
		mla.addResult(r2);
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		MLResult r3 = new MLResult(120,"JP","Tokyo","NTT",4312);
		mla.addResult(r3);
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		MLResult r4 = new MLResult(140,"HK","Central","Netvigator",4162);
		mla.addResult(r4);
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		MLResult r5 = new MLResult(160,"HK","Kowloon","HKBN",9269);
		mla.addResult(r5);
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		mla.addResult(new MLResult(110,"JP","Nagoya","DoCoMo",9123));
		mla.addResult(new MLResult(100,"JP","Nagoya","DoCoMo",9123));
		mla.addResult(new MLResult(140,"HK","Kowloon","HKBN",9269));
		mla.addResult(new MLResult(170,"HK","Kowloon","HKBN",9269));
		mla.addResult(new MLResult(100,"JP","Kyoto","DoCoMo",9123));
		mla.addResult(new MLResult(180,"HK","Central","Netvigator",4162));
		mla.addResult(new MLResult(190,"HK","Central","Netvigator",4162));
		mla.addResult(new MLResult(160,"HK","Central","Netvigator",4163));
		mla.addResult(new MLResult(90,"HK","Central","HGC",4142));
		mla.addResult(new MLResult(80,"HK","Central","HGC",4142));
		mla.addResult(new MLResult(130,"JP","Tokyo","NTT",4312));
		mla.addResult(new MLResult(120,"JP","Tokyo","DoCoMo",9123));
		mla.addResult(new MLResult(80,"HK","Kowloon","Smartone",9213));
		System.out.println("Results: " + mla.getNumResults() + " - Countries: " + mla.numCountries()
		 + " - Regions: " + mla.numRegions() + " - ISPs: " + mla.numIsps());

		List<MLAnonimizedSummary> summaries = mla.getAnonimizedResults(minResults);
		for(MLAnonimizedSummary summary : summaries) {
			System.out.println(summary);
		}
	}
}