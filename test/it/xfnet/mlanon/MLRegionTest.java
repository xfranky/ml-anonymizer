package it.xfnet.mlanon;

public class MLRegionTest {

	public static void main(String[] args) {
		MLCountry testCountry = new MLCountry("Test Country");
		MLRegion testRegion = new MLRegion("Test Region", testCountry);
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(10,testCountry.getCountryName(),"Test Region","Test ISP 1",1234));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(20,testCountry.getCountryName(),"Test Region","Test ISP 1",1234));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(12,testCountry.getCountryName(),"Test Region","Test ISP 1",1235));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(10,testCountry.getCountryName(),"Test Region","Test ISP 1",1235));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(18,testCountry.getCountryName(),"Test Region","Test ISP 2",1335));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(26,testCountry.getCountryName(),"Test Region","Test ISP 2",1335));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(9,testCountry.getCountryName(),"Test Region","Test ISP 2",1336));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(15,testCountry.getCountryName(),"Test Region","Test ISP 1",1234));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(19,testCountry.getCountryName(),"Test Region","Test ISP 3",3234));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(18,testCountry.getCountryName(),"Test Region","Test ISP 3",3235));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(18,testCountry.getCountryName(),"Test Region","Test ISP 4",4235));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());
		testRegion.addResult(new MLResult(18,testCountry.getCountryName(),"Test Region","Test ISP 5",5235));
		System.out.println(testRegion.getAverageSpeed() + "|" + testRegion.getMaxSpeed());

		java.util.List<MLAnonimizedSummary> summaries = new java.util.LinkedList<MLAnonimizedSummary>();
		testRegion.addAnonimizedResults(summaries, 3);
		for(MLAnonimizedSummary summary : summaries) {
			System.out.println(summary);
		}
	}
}