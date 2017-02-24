import javax.swing.DefaultListModel;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class OpenFile {
	//declare variable
	private JFileChooser fileChooser = new JFileChooser();
	public DefaultListModel<String> sb = new DefaultListModel<>();
	
	public void PickMe() throws Exception{
		//if you choose a file..
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
		//get the file
			java.io.File file = fileChooser.getSelectedFile();
			
		//create a scanner for the file
			Scanner input = new Scanner(file);
			
		//read text from file
			while(input.hasNext()){
				sb.addElement(input.nextLine());
			}
			input.close(); //close file after reading
		}
		else{
			sb.addElement("No file was selected");
		}
	}
			
			
			
}
