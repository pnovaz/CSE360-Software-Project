import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;

public class Gui360 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui360 window = new Gui360();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui360() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 552, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

	
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(Color.DARK_GRAY);
		btnHelp.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnHelp.setBounds(429, 369, 117, 29);
		frame.getContentPane().add(btnHelp);
		
		JButton btnInputFile = new JButton("Input File");
		btnInputFile.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnInputFile.setForeground(Color.DARK_GRAY);
		btnInputFile.setBackground(Color.BLACK);
		btnInputFile.setBounds(45, 6, 117, 29);
		frame.getContentPane().add(btnInputFile);
		
		JButton btnDictionaryFile = new JButton("Dictionary File");
		btnDictionaryFile.setForeground(Color.DARK_GRAY);
		btnDictionaryFile.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnDictionaryFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDictionaryFile.setBounds(261, 6, 117, 29);
		frame.getContentPane().add(btnDictionaryFile);
		
		JButton btnAddWord = new JButton("Add Word");
		btnAddWord.setForeground(Color.DARK_GRAY);
		btnAddWord.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnAddWord.setBounds(416, 82, 117, 29);
		frame.getContentPane().add(btnAddWord);
		
		JButton btnAddAllWords = new JButton("Add All Words");
		btnAddAllWords.setForeground(Color.DARK_GRAY);
		btnAddAllWords.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnAddAllWords.setBounds(416, 118, 117, 29);
		frame.getContentPane().add(btnAddAllWords);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(21, 47, 184, 280);
		frame.getContentPane().add(scrollPane1);
		
		JTextArea textArea1 = new JTextArea();
		scrollPane1.setViewportView(textArea1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(230, 47, 184, 280);
		frame.getContentPane().add(scrollPane2);
		
		JTextArea textArea2 = new JTextArea();
		scrollPane2.setViewportView(textArea2);
		
		JButton btnIgnore = new JButton("Ignore Word");
		btnIgnore.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnIgnore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIgnore.setBounds(416, 149, 117, 29);
		frame.getContentPane().add(btnIgnore);
		


		btnInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
				//when you click the input button it creates this new file
				OpenFile of = new OpenFile();
				
				try{
					of.PickMe();
				
<<<<<<< HEAD
				
=======
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
				}
				catch (Exception e){
					e.printStackTrace();
				}
<<<<<<< HEAD
				System.out.println(of.returnS(0));
				textArea1.setText(of.sb.toString());
			}
		});
		
		btn AddAllWords.addACtionListener(new ActonListener() {
			public void actionPerformed(ActionEvent event){
				//When you click the Add All Words button, it adds all of the words from the input file into the dictionary file
				
				
			}
		});
		
		btn AddWord.addActionListener(new Action Listener() {
			public void actonPerformed(ActionEvent event)  {
				
			}
		});
=======
				textArea1.setText(of.sb.toString());
			}
		});
>>>>>>> 6d7014c4e1ddb207abef89c6f72f477f20dcddf5
		}	
}
			

