package it.xfnet.mlanon;

public class MLCountryTest {
	public static void main(String[] args) {
		int minResults = 2;
		if (args.length > 0) {
			minResults = Integer.parseInt(args[0]);
		}
		MLCountry testCountry = new MLCountry("Test Country");
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(10,"Test Country","Test Region 1","Test ISP 1.1",1234));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(20,"Test Country","Test Region 1","Test ISP 1.1",1235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(18,"Test Country","Test Region 1","Test ISP 1.1",1235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(30,"Test Country","Test Region 2","Test ISP 2.1",2235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(24,"Test Country","Test Region 2","Test ISP 2.1",2235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(15,"Test Country","Test Region 2","Test ISP 2.1",2235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(16,"Test Country","Test Region 2","Test ISP 2.1",2234));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(19,"Test Country","Test Region 2","Test ISP 2.2",2236));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(18,"Test Country","Test Region 3","Test ISP 3.1",3235));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(16,"Test Country","Test Region 3","Test ISP 3.2",3236));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(16,"Test Country","Test Region 4","Test ISP 4.1",4236));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());
		testCountry.addResult(new MLResult(16,"Test Country","Test Region 5","Test ISP 5.1",5236));
		System.out.println(testCountry.getAverageSpeed() + "|" + testCountry.getMaxSpeed());

		java.util.List<MLAnonymizedSummary> summaries = new java.util.LinkedList<MLAnonymizedSummary>();
		testCountry.addAnonymizedResults(summaries, minResults);
		for(MLAnonymizedSummary summary : summaries) {
			System.out.println(summary);
		}
	}
}