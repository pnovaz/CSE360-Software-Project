/** 
 * CSE360 Project: a simple program that filters unknown words from a given file. 
 * 
 * @author todo: GroupName
 * @author Petra Novakovic
 * @author Daniel Bakhshpour
 * @author Alexandra Gibson
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
	 * Finds words that are in the set of words from the input file(s) that are not in the set of words from the dictionary file(s)
	 * @author David
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
	 * Converts a HashSet to a ListModel in order to print to the JPanel
	 * @author Daniel
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
	 * Filters an input by removing numbers, white-spaces, and special
	 * @author Daniel
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
	 * Initializes the contents of the frame.
	 * @author Petra
	 * @param inputWords The hash set containing the words from the input file
	 * @param dictionary The hash set containing the words from the dictionary file
	 * @param undocumentedWords	The hash set containing the words in the input file but not in the dictionary. It is initially empty.
	 * @param statisticsTracker An array of integers representing the counters that track user's action. It has 5 element and each element represent the following: words replaced counter, number of words in input file, number of words added to the dictionary, number of lines read from the input file, number of words ignored. 
	 */
	public static void initialize(HashSet<String> inputWords, HashSet<String> dictionary, HashSet<String> undocumentedWords, int[] statisticsTracker) {
		
		/**
		 * Frame helpers.
		 */
		FRAME = new JFrame();
		FRAME.getContentPane().setBackground(Color.ORANGE);
		FRAME.getContentPane().setForeground(Color.ORANGE);
		FRAME.setBounds(100, 100, 552, 553);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().setLayout(null);
		//end frame helpers
		
		/**
		 * Buttons implementation
		 */
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
		
		JButton ignoreButton = new JButton("Ignore Word");
		ignoreButton.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		ignoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ignoreButton.setBounds(429, 262, 117, 29);
		FRAME.getContentPane().add(ignoreButton);
		
		JButton btnReplaceWord = new JButton("Replace Word");
		btnReplaceWord.setBounds(429, 303, 117, 29);
		FRAME.getContentPane().add(btnReplaceWord);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(429, 155, 117, 29);
		FRAME.getContentPane().add(btnStatistics);
		//end Buttons implementation
		
		/**
		 * Scroll panes initialization
		 */
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
		//end scroll panes initialization
		
		/**
		 * Alert panels implementation
		 */
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
					resetTrackers(statisticsTracker);
					
					PickMe("input", inputWords, statisticsTracker);
					//update tracker: number of words in the input file
					statisticsTracker[1] = inputWords.size();
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
					resetTrackers(statisticsTracker);
					PickMe("dict", dictionary, statisticsTracker);
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
                //get selected value from list1 (inputed file)
                
                List<String> selectedWord = LEFTSCROLLPANECONTENT.getSelectedValuesList();
                
                //update number of words added to dictionary
                statisticsTracker[2] += selectedWord.size();
                
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
         * @author Petra Novakovic
         */
        ignoreButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent argo0){
              
                //get selected value from list1 (inputted file)
            	List<String> selectedWord = LEFTSCROLLPANECONTENT.getSelectedValuesList();
            	
                int selectedIndex = LEFTSCROLLPANECONTENT.getSelectedIndex();
             
                //((DefaultListModel) LEFTSCROLLPANECONTENT.getModel()).remove(selectedIndex);
                
                //update number of words ignored
                statisticsTracker[4] = selectedWord.size();
                
                //update and display current jlists after ignoring
                undocumentedWords.removeAll(selectedWord);
                LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
                RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
                
                inputAlert.setText(selectedWord.toString() + " ignored!");
            }
        });
        
        /**
         * Selects all words in the input file JList and adds to dictionary JList
         * @author Petra Novakovic
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
                    
        		 //update number of words added to dictionary
                   statisticsTracker[2] += selectedWords.size();
                   
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
      * Replace word button removes a selected word from the input, prompts user for a replacement and adds the replacement to the input file
      * @author Petra Novakovic
      */
     btnReplaceWord.addActionListener(new ActionListener () {
  	  
              public void actionPerformed(ActionEvent argo0){
              	
              	List<String> selectedWord = LEFTSCROLLPANECONTENT.getSelectedValuesList();
              	JFrame frame = new JFrame("Input Dialogue");
              	String replacement = JOptionPane.showInputDialog(frame, "What word will replace this selected word?");

                  // get the user's input. note that if they press Cancel, 'name' will be null
                  System.out.printf("The user's replacement is '%s'.\n", replacement);
                 
          		   //remove selected word and add replacement
                  
          		   dictionary.remove(selectedWord);  
          		   undocumentedWords.removeAll(selectedWord);
          		   inputWords.remove(selectedWord);
          		   inputWords.add(replacement);
          		   undocumentedWords.add(replacement);
  	                        
          		   LEFTSCROLLPANECONTENT.setModel(convertToListModel(undocumentedWords));
          		   RIGHTSCROLLPANECONTENT.setModel(convertToListModel(dictionary));
  	       
          		   inputAlert.setText(selectedWord.toString().substring(1, selectedWord.toString().length()- 1) + " replaced with " + replacement.toString().trim());
          		   statisticsTracker[0]++;
          		   System.out.println(statisticsTracker[0]);
          		   
          		   try{
	        		   File fileInput = new File("src/input.txt"); //file in src folder, path of file to be modified
	        		   
	        		   String oldContent = "";
            		   String selected = selectedWord.toString().substring(1, selectedWord.toString().length()- 1);
            		   String replacementWord = replacement.toString();
 
                     
            		   BufferedReader reader = new BufferedReader(new FileReader(fileInput));
            		   String line = "";
	        		   String oldText = "";
	    
	                   //read all lines of input.txt and append to oldContent String
	              
	                   while ((line = reader.readLine()) != null) {
	                   	oldContent += line + "\r\n";
	                   }
	                   
	                   reader.close();
	                   
	                   //replace all the occurences of oldString with newString using replace() method
	                   
	                  String newContent = oldContent.replaceAll(selected, replacementWord); //add replacement word to file
	                  
	                  //create FileWriter object to write newContent back into the input text fileToBeModified
	                  FileWriter writer = new FileWriter(fileInput);
	                  
	                  //rewrite file with new content using write()
	                   
	                   writer.write(newContent);
	                   
	                   writer.close();
	                }
          		   catch (IOException e) {
	              	  e.printStackTrace();
          		   }
              }
   });
   
     /**
      * Statistics button writes the statistics (user's actions) to a statistics file
      * @author Olu Gbadebo
      */
  btnStatistics.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0){
			try {
				File statsFile = new File("src/statistics.txt");
				FileWriter writer = new FileWriter(statsFile);
				String output = "Number of words replaced: " + statisticsTracker[0] + "\n" +
						"Number of words in input file: " + statisticsTracker[1] + "\n" +
						"Number of words added to the dictionary: " + statisticsTracker[2] + "\n" + 
						"Number of lines read from the input file: " +statisticsTracker[3] + "\n" +
						"number of words ignored: " + statisticsTracker[4];
				
				writer.write(output);
				writer.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
  });
   
  		/**
         * HELP! GUI
         * @author Alexandra Gibson
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
	 * Handles multiple file inputs and adds the contents of each file to the inputWords set
	 * @author Petra Novakovic
	 * @param hashChooser A string that helps to determine whether or not filterText method should be used 
	 * @param wordStorage TA hash set
	 * @throws Exception Any type of exception that might be thrown
	 */
	public static void PickMe(String hashChooser, HashSet<String> wordStorage, int[] statisticsTracker) throws Exception{
		
		fileChooser.setMultiSelectionEnabled(true);
		
		//if you choose a file..
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			//gets multiple files
			File[] files = fileChooser.getSelectedFiles();
			
			if (hashChooser == "input") {
				for(int i = 0; i < files.length; i++){
					
					final BufferedReader TEMPORARYREADER = new BufferedReader(new FileReader(files[i]));
				    
					try {
				        String readInputLine;
				        
				        while ((readInputLine = TEMPORARYREADER.readLine()) != null) {
				        	statisticsTracker[3]++;
				        	wordStorage.add(filterText(readInputLine));
				        }				        
				    } finally {
				        TEMPORARYREADER.close();
				    }
				    
				}
			}
			else {
				for(int i = 0; i < files.length; i++){
					
					final BufferedReader TEMPORARYREADER = new BufferedReader(new FileReader(files[i]));
				    
					try {
				        String readInputLine;
				        
				        while ((readInputLine = TEMPORARYREADER.readLine()) != null) {
				        	wordStorage.add(readInputLine);
				        }				        
				    } finally {
				        TEMPORARYREADER.close();
				    }
				}
			}
		}
	}
	
	/**
	 * Resets all the statistics tracker to zero
	 * @author Olu Gbadebo
	 * @param statisticsTracker
	 */
	public static void resetTrackers(int[] statisticsTracker){
		for (int key : statisticsTracker){
			key = 0;
		}
	}
	
	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		HashSet<String> inputWords = new HashSet<String>();
		HashSet<String> dictionary = new HashSet<String>();
		HashSet<String> undocumentedWords = new HashSet<String>();
		int[] statisticsTracker = new int[5];
		
		resetTrackers(statisticsTracker);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					initialize(inputWords, dictionary, undocumentedWords, statisticsTracker);
					FRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}