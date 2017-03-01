/* CSE360 Project
 * 
 * By: //TODO:GroupName
 * Team members: Olu David Gbabebo
 * 
 */

//all necessary packages are imported here 
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import java.awt.Font;

import java.util.*;

import java.io.*;

//end package imports


//class definition
public class Spellchecker {
	
	//TODO: comment
	private JFileChooser fileChooser = new JFileChooser();
	public DefaultListModel<String> sb = new DefaultListModel<>();
	private JFrame frame;
	
	//By David
	//This method finds words that are in the set of words from the input file(s) 
	//that are not in the set of words from the dictionary file(s)
	public static void ListUnknownWords(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords){
		//while iterating thru the inputWords set
		for(String currentWord : inputWords){
			//is the current word in the dictionary?
			if(!dictionary.contains(currentWord)){
				//if the current word is not in the dictionary
				//add the word to the set of undocumented words
				undocumentedWords.add(currentWord);
			}
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
	
	//By Daniel
	//This method converts a HashSet to a ListModel in order to print to the JPanel
	public static DefaultListModel<String> convertToListModel(HashSet<String> hashSet){
		DefaultListModel<String> list = new DefaultListModel<String>();
		
		for(String word : hashSet){
			list.addElement(word);
		}
		
		return list;
	}
	
	//By Daniel
	//This method filters an input by removing numbers, whitespaces, and special
	//characters
	public static String filterText(String inputText)
	{
		String temp = inputText;
		
		//Replaces non-letter characters with ""
		temp = temp.replaceAll("\\d", "");
		temp = temp.replaceAll("\\W", "");
		
		return temp;
	}
	

	/**
	 * Create the application.
	 */
	public Spellchecker(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords) {
		initialize(inputWords, dictionary, undocumentedWords);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 552, 553);
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
		btnInputFile.setBounds(45, 95, 117, 29);
		frame.getContentPane().add(btnInputFile);
		
		JButton btnDictionaryFile = new JButton("Dictionary File");
		btnDictionaryFile.setForeground(Color.DARK_GRAY);
		btnDictionaryFile.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnDictionaryFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDictionaryFile.setBounds(264, 95, 117, 29);
		frame.getContentPane().add(btnDictionaryFile);
		
		JButton btnAddWord = new JButton("Add Word");
		btnAddWord.setBackground(Color.GREEN);
		btnAddWord.setForeground(Color.DARK_GRAY);
		btnAddWord.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnAddWord.setBounds(429, 191, 117, 29);
		frame.getContentPane().add(btnAddWord);
		
		JButton btnAddAllWords = new JButton("Add All Words");
		btnAddAllWords.setForeground(Color.DARK_GRAY);
		btnAddAllWords.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnAddAllWords.setBounds(429, 226, 117, 29);
		frame.getContentPane().add(btnAddAllWords);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(21, 133, 184, 280);
		frame.getContentPane().add(scrollPane1);
		
		final JList <String> list = new JList<>();
		scrollPane1.setViewportView(list);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(233, 133, 184, 280);
		frame.getContentPane().add(scrollPane2);
		
		final JList list2 = new JList();
		scrollPane2.setViewportView(list2);
		
		JButton btnIgnore = new JButton("Ignore Word");
		btnIgnore.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		btnIgnore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIgnore.setBounds(429, 262, 117, 29);
		frame.getContentPane().add(btnIgnore);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setForeground(Color.RED);
		inputPanel.setBackground(Color.WHITE);
		inputPanel.setBounds(21, 441, 184, 29);
		frame.getContentPane().add(inputPanel);
		
		JLabel inputAlert = new JLabel("");
		inputAlert.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		inputAlert.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(inputAlert);
		
		JPanel dictionaryPanel = new JPanel();
		dictionaryPanel.setForeground(Color.RED);
		dictionaryPanel.setBackground(Color.WHITE);
		dictionaryPanel.setBounds(233, 445, 184, 25);
		frame.getContentPane().add(dictionaryPanel);
		
		JLabel dictionaryAlert = new JLabel("");
		dictionaryPanel.add(dictionaryAlert);
		
		JLabel header = new JLabel("The Amazing SpellChecker :)");
		header.setForeground(Color.BLUE);
		header.setFont(new Font("American Typewriter", Font.BOLD, 29));
		header.setBounds(70, 24, 443, 37);
		frame.getContentPane().add(header);
		
	
	//INPUT A FILE BUTTON IMPLEMENTATION
		btnInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
				try{
					PickMe("input", inputWords);
					ListUnknownWords(inputWords, dictionary, undocumentedWords);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				list2.setModel(convertToListModel(dictionary));
				list.setModel(convertToListModel(undocumentedWords));
			
			inputAlert.setText("Input File added!");
		
		}});
		//add a dictionary file button implementation
		btnDictionaryFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo0){
				
				try{
					PickMe("dict", dictionary);
					ListUnknownWords(inputWords, dictionary, undocumentedWords);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				list2.setModel(convertToListModel(dictionary));
				list.setModel(convertToListModel(undocumentedWords));
				
				dictionaryAlert.setText("Dictionary Added!");
			}
		});
        
        //Add Word Button Action Listener
        //Created by PETRA NOVAKOVIC
		//adds both only one word or multiple words if the user chooses!
        
        btnAddWord.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent argo0){
                
           
                //get selected value from list1 (inputted file)
                
                String selectedWord = list.getSelectedValue();
                
                //place selected value into list2
                dictionary.add(selectedWord);
                
               list2.setModel(convertToListModel(dictionary));
                
                dictionaryAlert.setText("Word Added!");
            }
        });
        
        //HELP! GUI by Alexandra Gibson
        btnHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                //When you click the Help button a message box will appear with help instructions
                String text = "<html>HELP!<br> "
                + "<b>Step 1: Dictionary File</b><br> "
                + " Click the Dictionary File Button.<br>"
                + "  Select a text file to open.<br><br>"
                + "<b>Step 2: Input file</b><br> "
                + " Click the Input File Button.<br> "
                + " Select a text file to open.<br><br> "
                + "<b>Add Word Button:</b><br> "
                + " Adds selected word(s) from the Input file to the Dictionary file.<br><br> "
                + "<b>Add All Words Button:</b><br> "
                + " Adds all of the words from the Input file.<br><br> "
                + "<b>Ignore Word Button:</b><br> "
                + " Removes the selected word(s) from the input file. </html>";
                JLabel message = new JLabel(text);
                message.setFont(new Font("serif", Font.PLAIN, 14));
                JOptionPane.showMessageDialog(null, message);
                
            }
        });
        
	}	
		
	//By Petra and David
	//This method handles multiple file inputs and adds the contents of each
	//file to the inputWords set
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
			        		wordStorage.add(filterText(strLine));
			        	}
			        	else {
			        		wordStorage.add(strLine);
			        	}
			        }
			    } finally {
			        br.close();
			    }}}
			
        }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		HashSet<String> inputWords = new HashSet<String>();
		HashSet<String> dictionary = new HashSet<String>();
		HashSet<String> undocumentedWords = new HashSet<String>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spellchecker window = new Spellchecker(inputWords, dictionary, undocumentedWords);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
