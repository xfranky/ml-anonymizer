package it.xfnet.mlanon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MLResultLoader {

	static void loadResultCsv(String fileName, MultiLevelAnonymizer mla) {
		String line;
		MLResult result;
		try {
			// Open the file in a BufferedReader
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			// Go line by line and try parsing the results
			while((line = br.readLine()) != null) {
				result = parseResultLine(line);
				mla.addResult(result);
			}
		}
		catch (IOException e) {
			System.out.println("Error opening file: " + e);
		}
	}

	static MLResult parseResultLine(String resultLine) {
		String[] resultData = resultLine.split(";");
		if(resultData.length != 5) {
			return null;
		}
		return new MLResult(Long.parseLong(resultData[0]), 
							resultData[1], 
							resultData[2], 
							resultData[3], 
							Integer.parseInt(resultData[4]));
	}
}