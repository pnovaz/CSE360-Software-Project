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

import java.util.*;
public class Gui360 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		HashSet<String> wordStr = new HashSet<String>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui360 window = new Gui360(wordStr);
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
	public Gui360(HashSet<String> wordStr) {
		initialize(wordStr);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(HashSet<String> wordStr) {
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
				
				//when you click the input button it creates this new file
				OpenFile of = new OpenFile();
				
				try{
					of.PickMe(wordStr);
				
				}
				catch (Exception e){
					e.printStackTrace();
				}
				//System.out.println(o);
				list.setModel((ListModel<String>) wordStr);
			}
			
		
		});
		
		btnDictionaryFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo0){
				
				OpenFile of = new OpenFile();
				
				try{
					of.PickMe(wordStr);
				
				}
				catch (Exception e){
					e.printStackTrace();
				}
				//System.out.println(o);
				list2.setModel(of.sb);
			}
		});
		

		}	
}
			

