/** 
 * CSE360 Project: a simple program that filters unknown words from a given file. 
 * 
 * @author todo: GroupName
 * @author Petra
 * @author Daniel
 * @author Ally
 * @author Olu David Gbadebo
 * 
 * @version 1.0
 * 
 */


/** all necessary packages are imported in this block */ 
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.io.*;



/**
 *  This is the main class
 */
public class Spellchecker {
	
	/** @param fileChooser fileChooser serves as the dynamic object that allows users to select files */
	private static JFileChooser fileChooser = new JFileChooser();
	
	/** @param FRAME FRAME is the JFrame for the GUI */
	private static JFrame FRAME;
	
	/** 
	 * @author David
	 * Finds words that are in the set of words from the input file(s) that are not in the set of words from the dictionary file(s)
	 * @param inputWords The hash set containing the words from the input file
	 * @param dictionary The hash set containing the words from the dictionary file
	 * @param undocumentedWords	The hash set containing the words in the input file but not in the dictionary. It is initially empty.
	 */
	public static void ListUnknownWords(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords){
		
		if (!dictionary.isEmpty()){
			
			//while iterating thru the inputWords set
			for(String eachWordInInputWords : inputWords){
				
				//is the current word in the dictionary?
				if(!dictionary.contains(eachWordInInputWords)){
					//if the current word is not in the dictionary
					//add the word to the set of undocumented words
					undocumentedWords.add(eachWordInInputWords);
				}
				
			}
			
			//remove all the words in the inputWords set 
			//so that the set is empty and ready for new words from another input file.
			//This way the words that are already checked won't be checked again.
			inputWords.clear();
		}
	}
	
	/**
	 * @author Daniel
	 * 
	 * Converts a HashSet to a ListModel in order to print to the JPanel
	 * @param setToConvert The hash set that will be converted to a List Model
	 * @return A List Model data structure
	 */
	public static DefaultListModel<String> convertToListModel(HashSet<String> setToConvert){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(String eachWordInHashSet : setToConvert){
			listModel.addElement(eachWordInHashSet);
		}
		
		return listModel;
	}
	
	/**
	 * @author Daniel
	 * 
	 * Filters an input by removing numbers, white-spaces, and special
	 * @param inputText The text to be filtered
	 * @return A string representing the filtered input text
	 */
	public static String filterText(String inputText)
	{
		String filteredText = inputText;
		
		//Replaces non-letter characters with ""
		filteredText = filteredText.replaceAll("\\d", "");
		filteredText = filteredText.replaceAll("\\W", "");
		
		return filteredText;
	}
	
	/**
	 * @author Petra
	 * Initializes the contents of the frame.
	 * @param inputWords The hash set containing the words from the input file
	 * @param dictionary The hash set containing the words from the dictionary file
	 * @param undocumentedWords	The hash set containing the words in the input file but not in the dictionary. It is initially empty.
	 */
	private static void initialize(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords) {
		FRAME = new JFrame();
		FRAME.getContentPane().setBackground(Color.ORANGE);
		FRAME.getContentPane().setForeground(Color.ORANGE);
		FRAME.setBounds(100, 100, 552, 553);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().setLayout(null);
		
	
	
		JButton helpButton = new JButton("Help");
		helpButton.setForeground(Color.DARK_GRAY);
		helpButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		helpButton.setBounds(429, 369, 117, 29);
		FRAME.getContentPane().add(helpButton);
		
		JButton inputFileButton = new JButton("Input File");
		inputFileButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		inputFileButton.setForeground(Color.DARK_GRAY);
		inputFileButton.setBackground(Color.BLACK);
		inputFileButton.setBounds(45, 95, 117, 29);
		FRAME.getContentPane().add(inputFileButton);
		
		JButton dictionaryFileButton = new JButton("Dictionary File");
		dictionaryFileButton.setForeground(Color.DARK_GRAY);
		dictionaryFileButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		dictionaryFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dictionaryFileButton.setBounds(264, 95, 117, 29);
		FRAME.getContentPane().add(dictionaryFileButton);
		
		JButton addWordButton = new JButton("Add Word");
		addWordButton.setBackground(Color.GREEN);
		addWordButton.setForeground(Color.DARK_GRAY);
		addWordButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		addWordButton.setBounds(429, 191, 117, 29);
		FRAME.getContentPane().add(addWordButton);
		
		JButton addAllWordsButton = new JButton("Add All Words");
		addAllWordsButton.setForeground(Color.DARK_GRAY);
		addAllWordsButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		addAllWordsButton.setBounds(429, 226, 117, 29);
		FRAME.getContentPane().add(addAllWordsButton);
		
		JScrollPane leftScrollPane = new JScrollPane();
		leftScrollPane.setBounds(21, 133, 184, 280);
		FRAME.getContentPane().add(leftScrollPane);
		
		final JList <String> LEFTSCROLLPANECONTENT = new JList<>();
		leftScrollPane.setViewportView(LEFTSCROLLPANECONTENT);
		
		JScrollPane rightScrollPane = new JScrollPane();
		rightScrollPane.setBounds(233, 133, 184, 280);
		FRAME.getContentPane().add(rightScrollPane);
		
		final JList RIGHTSCROLLPANECONTENT = new JList();
		rightScrollPane.setViewportView(RIGHTSCROLLPANECONTENT);
		
		JButton ignoreButton = new JButton("Ignore Word");
		ignoreButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		ignoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ignoreButton.setBounds(429, 262, 117, 29);
		FRAME.getContentPane().add(ignoreButton);
		
		JPanel leftAlertPanel = new JPanel();
		leftAlertPanel.setForeground(Color.RED);
		leftAlertPanel.setBackground(Color.WHITE);
		leftAlertPanel.setBounds(21, 441, 184, 29);
		FRAME.getContentPane().add(leftAlertPanel);
		
		JLabel inputAlert = new JLabel("");
		inputAlert.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		inputAlert.setHorizontalAlignment(SwingConstants.CENTER);
		leftAlertPanel.add(inputAlert);
		
		JPanel rightAlertPanel = new JPanel();
		rightAlertPanel.setForeground(Color.RED);
		rightAlertPanel.setBackground(Color.WHITE);
		rightAlertPanel.setBounds(233, 445, 184, 25);
		FRAME.getContentPane().add(rightAlertPanel);
		
		JLabel dictionaryAlert = new JLabel("");
		rightAlertPanel.add(dictionaryAlert);
		
		JLabel windowHeader = new JLabel("The Amazing SpellChecker :)");
		windowHeader.setForeground(Color.BLUE);
		windowHeader.setFont(new Font("American Typewriter", Font.BOLD, 29));
		windowHeader.setBounds(70, 24, 443, 37);
		FRAME.getContentPane().add(windowHeader);
	
		/**
		 * Button listener for input file button
		 */
		inputFileButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0){
				
				try{
					PickMe("input", inputWords);
					ListUnknownWords(inputWords, dictionary, undocumentedWords);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
				RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
				
			
				inputAlert.setText("Input File added!");
			}
		});
		
		/**
		 *  Button listener for dictionary file button
		 */
		dictionaryFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo0){
				
				try{
					PickMe("dict", dictionary);
					ListUnknownWords(inputWords, dictionary, undocumentedWords);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
				LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
				
				dictionaryAlert.setText("Dictionary Added!");
			}
		});
        
        /**
         * Button listener to add only one word or multiple words if the user chooses!
         */
        addWordButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent argo0){
                
           
                //get selected value from list1 (inputted file)
                
                List<String> selectedWord = LEFTSCROLLPANECONTENT.getSelectedValuesList();
                
                //place selected value into list2
                dictionary.addAll(selectedWord);
                undocumentedWords.removeAll(selectedWord);
                
                LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
                RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
                
                dictionaryAlert.setText(selectedWord.toString() + " added!");
            }
        });
        
        /**
         * Button listener to delete word from the input files JList 
         */
        ignoreButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent argo0){
              
                //get selected value from list1 (inputted file)
            	String selectedWord = LEFTSCROLLPANECONTENT.getSelectedValue();
                int selectedIndex = LEFTSCROLLPANECONTENT.getSelectedIndex();
             
                ((DefaultListModel) LEFTSCROLLPANECONTENT.getModel()).remove(selectedIndex);
                
                //update and display current jlists after ignoring
                undocumentedWords.remove(selectedWord);
                LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
                RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
                
                inputAlert.setText(selectedWord.toString() + " ignored!");
            }
        });
        
        /**
         * @author Petra
         * Selects all words in the input file jlist and adds to dictionary jlist
         */
        addAllWordsButton.addActionListener(new ActionListener () {
            
            public void actionPerformed(ActionEvent argo0){
            	
                
                //select all words currently in jlist by getting size of jlist
       
        	   int start = 0;
        	   int end = LEFTSCROLLPANECONTENT.getModel().getSize() - 1;
            
        	   if (end >= 0) {
        		   
        		   //selects all elements in first jlist
        		   LEFTSCROLLPANECONTENT.addSelectionInterval(start, end);
        		   List <String> selectedWords = LEFTSCROLLPANECONTENT.getSelectedValuesList();
                    
        		   //place all values into list2
        		   dictionary.addAll(selectedWords);        
        		   undocumentedWords.removeAll(selectedWords);
	                        
        		   LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
        		   RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
	                
        		   dictionaryAlert.setText("All Words Added!");
        	    }
            }
        });
        
        /**
         * @author Alexandra Gibson
         * HELP! GUI 
         */
        helpButton.addActionListener(new ActionListener() {
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
		
	/** 
	 * @author Petra
	 * Handles multiple file inputs and adds the contents of each file to the inputWords set
	 * 
	 * @param hashChooser A string that helps to determine whether or not filterText method should be used 
	 * @param wordStorage TA hash set
	 * @throws Exception Any type of exception that might be thrown
	 */
	public static void PickMe(String hashChooser, HashSet<String> wordStorage) throws Exception{
		
		fileChooser.setMultiSelectionEnabled(true);
		
		//if you choose a file..
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			//gets multiple files
			File[] files = fileChooser.getSelectedFiles();
			
			for(int i = 0; i < files.length; i++){
				
				final BufferedReader TEMPORARYREADER = new BufferedReader(new FileReader(files[i]));
			    
				try {
			        String readInputLine;
			        
			        while ((readInputLine = TEMPORARYREADER.readLine()) != null) {
			        	
			        	if (hashChooser == "input"){
			        		wordStorage.add(filterText(readInputLine));
			        	}
			        	else {
			        		wordStorage.add(readInputLine);
			        	}
			        	
			        }
			        
			    } finally {
			        TEMPORARYREADER.close();
			    }
			    
			}
		}
	}
	
	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		HashSet<String> inputWords = new HashSet<String>();
		HashSet<String> dictionary = new HashSet<String>();
		HashSet<String> undocumentedWords = new HashSet<String>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					initialize(inputWords, dictionary, undocumentedWords);
					FRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
