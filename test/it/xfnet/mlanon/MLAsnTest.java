package it.xfnet.mlanon;

public class MLAsnTest {
	public static void main (String [] args) {
		MLAsn testAsn = new MLAsn(1234, null);
		System.out.println(testAsn.getAverageSpeed() + "|" + testAsn.getMaxSpeed());
		testAsn.addResult(new MLResult(10, null, null, null, 1234));
		System.out.println(testAsn.getAverageSpeed() + "|" + testAsn.getMaxSpeed());
		testAsn.addResult(new MLResult(30, null, null, null, 1234));
		System.out.println(testAsn.getAverageSpeed() + "|" + testAsn.getMaxSpeed());
		testAsn.addResult(new MLResult(5, null, null, null, 1234));
		System.out.println(testAsn.getAverageSpeed() + "|" + testAsn.getMaxSpeed());
	}
}
