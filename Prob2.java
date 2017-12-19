import java.io.BufferedReader;
import java.io.FileReader;

public class Prob2 {
	
	// test only, normally would get the filenames from somewhere else
	static private String fileNameIn1 = "test1.txt";
	static private String fileNameIn2 = "test2.txt";
	
	public static void main (String[] args) {
		
		String lineIn1 = null;
		String lineIn2 = null;

		try {
			// use a simple reader, performance of read not listed as important here
			FileReader in1 = new FileReader(fileNameIn1);
			BufferedReader br1 = new BufferedReader(in1);
			FileReader in2 = new FileReader(fileNameIn2);
			BufferedReader br2 = new BufferedReader(in2);

			// prime
			lineIn1 = br1.readLine();
			lineIn2 = br2.readLine();
			while (lineIn1 != null && lineIn2 != null) {
				int comp = lineIn1.compareTo(lineIn2);
				if (comp == 0) {
					System.out.println(lineIn1);
					System.out.println(lineIn2);
					lineIn1 = br1.readLine();
					lineIn2 = br2.readLine();
				}
				else 
				if (comp > 0) { // file 2's value is lower
					System.out.println(lineIn2);
					lineIn2 = br2.readLine();
				}
				else 
				{
					System.out.println(lineIn1);
					lineIn1 = br1.readLine();
				}
			}
			
			in1.close();		
			in2.close();		
		}
		
		catch (Exception e) {
			System.out.println("Exception in Prob2: " + e.getMessage());
		}
	}
}
