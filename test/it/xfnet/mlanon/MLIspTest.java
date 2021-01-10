package it.xfnet.mlanon;

public class MLIspTest {
	public static void main(String[] args) {
		MLCountry testCountry = new MLCountry("Test Country");
		MLRegion testRegion = new MLRegion("Test Region", testCountry);
		MLIsp testIsp = new MLIsp("Test ISP",testRegion);
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(10,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1234));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(20,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1234));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(15,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",4321));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(23,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",4321));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(17,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1234));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(11,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1235));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(16,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1236));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(24,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1237));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());
		testIsp.addResult(new MLResult(12,testCountry.getCountryName(),testRegion.getRegionName(),"Test ISP",1234));
		System.out.println(testIsp.getAverageSpeed() + "|" + testIsp.getMaxSpeed());

		java.util.List<MLAnonimizedSummary> summaries = new java.util.LinkedList<MLAnonimizedSummary>();
		testIsp.addAnonimizedResults(summaries, 2);
		for(MLAnonimizedSummary summary : summaries) {
			System.out.println(summary);
		}
	}
}