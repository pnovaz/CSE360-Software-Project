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
	public static void ListUnknownWords(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> unknownWords){
		Iterator inputIterator = inputWords.iterator();
		
		while(inputIterator.hasNext()){
			if(!dictionary.contains(inputIterator.next()))
				unknownWords.add(inputIterator.next().toString());
		}
		inputWords.clear();
	}
	
	
}