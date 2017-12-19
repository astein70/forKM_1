import java.io.BufferedReader;
import java.io.FileReader;

public class Prob1 {
	
	// test only, normally would get the filename from somewhere else
	static private String fileNameIn = "test.txt";
	
	public static void main (String[] args) {
		
		String lineIn = null;
		String curCusip = null;
		String lastCusip = null;
		String lastPrice = null;

		try {
			// use a simple reader, performance of read not listed as important here
			FileReader in = new FileReader(fileNameIn);
			BufferedReader br = new BufferedReader(in);

			while ((lineIn = br.readLine()) != null) {
				// knowing that a CUSIP is alphanumeric but can contain all digits,
				// going to test for '.' to validate/confirm a price entry
				if (lineIn.indexOf('.') == -1) {
					curCusip = lineIn;
					if (lastCusip == null) {
						lastCusip = curCusip;
					}
				}
				else {
					lastPrice = lineIn;
				}
	    	
				if (curCusip != lastCusip) {
					System.out.println("Cusip: " + lastCusip + " closing price: " + lastPrice);
					lastCusip = curCusip;
				}
			}
			if (lastCusip != null) {
				System.out.println("Cusip: " + lastCusip + " closing price: " + lastPrice);
				lastCusip = curCusip;
			}
			
			in.close();		
		}
		
		catch (Exception e) {
			System.out.println("Exception in Prob1: " + e.getMessage());
		}
	}
}
