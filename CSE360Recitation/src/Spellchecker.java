/* CSE360 Project
 * 
 * By: //TODO:GroupName
 * Team members: Olu David Gbabebo
 * 
 */

import java.io.*;
import java.util.*;

public class Spellchecker {
	
	//By David
	//This method finds words that are in the set of words from the input file(s) 
	//that are not in the set of words from the dictionary file(s)
	public static void ListUnknownWords(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords){
		Iterator inputIterator = inputWords.iterator();	//iterates thru inputWords set
		
		//while iterating thru the inputWords set
		while(inputIterator.hasNext()){
			//is the current word in the dictionary?
			if(!dictionary.contains(inputIterator.next()))
				//if the current word is not in the dictionary
				//add the word to the set of undocumented words
				undocumentedWords.add(inputIterator.next().toString());
		}
		//remove all the words in the inputWords set 
		//so that the set is empty and ready for new words from another input file.
		//This way the words that are already checked won't be checked again.
		inputWords.clear();
	}

	//By David
	//this method handles user's interaction involving adding or ignoring 
	//undocumented words to the undocumentedWords set
	public static void addOrIgnore(HashSet<String> dictionary, HashSet<String> undocumentedWords){
		//TODO figure out how to get selected words from the GUI
	}
	
	//By David
	//This method handles multiple file inputs and adds the contents of each
	//file to the inputWords set
	public static void readFilesToSet(HashSet<String> inputWords, InputStream inputFile){
		int content;
		
		while((content = inputFile.read()) != -1){
			//inputWords.add(content);
		}
	}
	
}