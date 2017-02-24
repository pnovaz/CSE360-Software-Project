import java.util.Scanner;
import javax.swing.JFileChooser;

public class OpenFile {
	//declare variable
	JFileChooser fileChooser = new JFileChooser();
<<<<<<< HEAD
	private StringBuilder sb = new StringBuilder();
=======
	StringBuilder sb = new StringBuilder();
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
	
	public void PickMe() throws Exception{
		//if you choose a file..
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
		//get the file
			java.io.File file = fileChooser.getSelectedFile();
			
		//create a scanner for the file
			Scanner input = new Scanner(file);
			
		//read text from file
			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
			
			}
			input.close(); //close file after reading
		}
		else{
			sb.append("No file was selected");
<<<<<<< HEAD
			
		}
	}
	public String returnS(int index){
		return sb.substring(index);
	}		
=======
		}
	}
			
			
			
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
}
