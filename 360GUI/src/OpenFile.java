import javax.swing.DefaultListModel;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class OpenFile {
	//declare variable
<<<<<<< HEAD
	private JFileChooser fileChooser = new JFileChooser();
	public DefaultListModel<String> sb = new DefaultListModel<>();
=======
	JFileChooser fileChooser = new JFileChooser();
<<<<<<< HEAD
	private StringBuilder sb = new StringBuilder();
=======
	StringBuilder sb = new StringBuilder();
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
>>>>>>> 5f45e91fe2f0e5e4510eb68130d4a6e981b467fd
	
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
<<<<<<< HEAD
			sb.addElement("No file was selected");
=======
			sb.append("No file was selected");
<<<<<<< HEAD
			
		}
	}
	public String returnS(int index){
		return sb.substring(index);
	}		
=======
>>>>>>> 5f45e91fe2f0e5e4510eb68130d4a6e981b467fd
		}
	}
			
			
			
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
}
