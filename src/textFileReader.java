import java.io.*;
import java.util.*;


public class textFileReader {
	
	public static HashSet<String> filterText(String inputText)
	{
		String temp = null;
		HashSet<String> input = new HashSet<String>();
		
		try {
			
			FileReader fileReader = new FileReader(inputText);
			BufferedReader reader = new BufferedReader(fileReader);
			
			//Stores input.txt into an array named input
			while ((temp = reader.readLine()) != null) {
				//Replaces non-letter characters with ""
				temp = temp.replaceAll("\\d", "");
				temp = temp.replaceAll("\\W", "");
				//Adds filtered input.txt to arraylist called input
				if (!temp.isEmpty()) {
					input.add(temp);
				}
			}
			reader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(inputText + " " + "not found.");
		}
		catch(IOException ex) {
			System.out.println("Unable to read " + inputText);
		}
		return input;
	}
}

