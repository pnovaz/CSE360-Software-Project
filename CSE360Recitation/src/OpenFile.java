import javax.swing.DefaultListModel;
import java.util.*;
import javax.swing.JFileChooser;
import java.io.*;

public class OpenFile {
	//declare variable
	private JFileChooser fileChooser = new JFileChooser();
	public DefaultListModel<String> sb = new DefaultListModel<>();
	
	public void PickMe(String hashChooser, HashSet<String> wordStorage) throws Exception{
		fileChooser.setMultiSelectionEnabled(true);
		//if you choose a file..
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			//gets multiple files
			File[] files = fileChooser.getSelectedFiles();
			
			for(int i = 0; i < files.length; i++){
				final BufferedReader br = new BufferedReader(new FileReader(files[i]));
			    try {
			        String strLine;
			        while ((strLine = br.readLine()) != null) {
			        	if (hashChooser == "input"){
			        		wordStorage.add(textFileReader.filterText(strLine));
			        	}
			        	else {
			        		wordStorage.add(strLine);
			        	}
			        }
			    } finally {
			        br.close();
			    }
			}
		}	
			
		//get the file
			//java.io.File file = fileChooser.getSelectedFile();
			
		//create a scanner for the file
			//Scanner input = new Scanner(file);
			
//		//read text from file
//			while(input.hasNext()){
//				sb.addElement(input.nextLine());
//			}
//			input.close(); //close file after reading
//		}
//		else{
//			sb.addElement("No file was selected");
//		}
	}
			
			
			
}
