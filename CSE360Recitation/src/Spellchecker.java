/* CSE360 Project
 * 
 * By: //TODO:GroupName
 * Team members: Olu David Gbabebo
 * 
 */

//all necessary packages are imported here 
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ListModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.DefaultListModel;

import java.util.*;

import javax.swing.JFileChooser;

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
		
		final JList <String> list = new JList<>();
		scrollPane1.setViewportView(list);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(230, 47, 184, 280);
		frame.getContentPane().add(scrollPane2);
		
		final JList list2 = new JList();
		scrollPane2.setViewportView(list2);
		
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
				
				try{
					PickMe("input", inputWords);
					ListUnknownWords(inputWords, dictionary, undocumentedWords);
				}
				catch (Exception e){
					e.printStackTrace();
				}
				list2.setModel(convertToListModel(dictionary));
				list.setModel(convertToListModel(undocumentedWords));
			}
			
		
		});
		
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
			    }
			}
		}
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
