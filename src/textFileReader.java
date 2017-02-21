import java.io.*;
import java.util.*;



public class textFileReader {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		HashSet<String> input = new HashSet<String>();
		HashSet<String> dictionary = new HashSet<String>();	//Stores contents of input.txt
		String temp = null;														//Used to read input
		
		
		//Prompts for input.txt name
		System.out.print("Please enter the name of the input file");
		System.out.println();
		String inputText = scan.next();
		
		//prompts for dictionary.txt name
		System.out.print("Please enter the name of the dictionary");
		System.out.println();
		String dictionaryText = scan.next();
		
		
		//The process of opening the input text file and storing it in an arraylist called input
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
		
		
		//The process of opening the dictionary text file and storing it in an array called dictionary
		try {
			
			FileReader fileReader = new FileReader(dictionaryText);
			BufferedReader reader = new BufferedReader(fileReader);
			
			while ((temp = reader.readLine()) != null) {
				dictionary.add(temp);
			}
			
			
			reader.close();
			
		}
		catch(FileNotFoundException ex) {
			System.out.println(dictionaryText + " " + "not found.");
		}
		catch(IOException ex) {
			System.out.println("Unable to read " + dictionaryText);
		}
		
		//Prints filtered input.txt
		System.out.println("\nInput");
		Iterator<String> inputItr = input.iterator();
		while (inputItr.hasNext())
		{
			System.out.println(inputItr.next().toString());
		}
		
		//Prints dictionary
		System.out.println("\nDictionary");
		Iterator<String> dictionaryItr = dictionary.iterator();
		while (dictionaryItr.hasNext())
		{
			System.out.println(dictionaryItr.next().toString());
		}
	}
}//End of main
