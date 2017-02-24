import java.io.*;
import java.util.*;


public class textFileReader {
	
	public static String filterText(String inputText)
	{
		String temp = inputText;
		
		//Replaces non-letter characters with ""
		temp = temp.replaceAll("\\d", "");
		temp = temp.replaceAll("\\W", "");
		
		return temp;
	}
}

