
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * PalindromeTester is a class that takes a string as an argument
 * and tests whether a string is a palindrome or not, returning a boolean 
 * to signify this. It will test regardless of case, punctuation, or
 * blank spaces.
 * 
 * @author Joshua Michael Waggoner
 * @date 10.15.12
 */
public class PalindromeTester {
    
     //New Jframe frame
    JFrame frame;
    
    //String instructions
    String instructions = "This program tests whether or not" +
            " the user's input is a\n tester. It will test" +
            " regardless of case, punctuation,\n or blank spaces." +
            " Enter a sentence (or more for that matter)\n into" +
            " the text area below, and click on the 'Test!' button.";

    //Constructor
    public PalindromeTester() {
    	
    	//Make new Jframe and set the bounds and title
        frame = new JFrame();
        frame.setBounds(250,100,450,450);
        frame.setTitle("Palindrome Tester by Josh");
        
        //New container
        Container cp = frame.getContentPane();
        
        //JPanel stuff
        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();
        
        //JTextArea instruction area takes instructions as argument
        JTextArea instructionArea = new JTextArea(instructions);
        
        //JTextArea textArea
        final JTextArea textArea = new JTextArea(15, 30);
        JButton test = new JButton("Test!");
        
        //Add top, bottom, and center to the content pane
        cp.add(top, BorderLayout.NORTH);
        cp.add(center, BorderLayout.CENTER);
        cp.add(bottom, BorderLayout.SOUTH);

        //Add instructionArea to the top
        top.add(instructionArea);
        
        //Add textArea to center
        center.add(textArea);
        
        //Add test to the bottom
        bottom.add(test);
        
        //Colors
        instructionArea.setBackground(Color.BLACK);
        instructionArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.magenta);
        textArea.setForeground(Color.WHITE);    
        top.setBackground(Color.BLACK);
        center.setBackground(Color.BLACK);
        bottom.setBackground(Color.BLACK);
        
        //Set frame visible
        frame.setVisible(true);
        
        //Add action listener to test
        test.addActionListener(new ActionListener() {
        	//When the button is pressed, performs following
            public void actionPerformed(ActionEvent e) {
            	
            	//The string sentence is assigned the text from the textArea
                String sentence = textArea.getText();
                
                //If the sentence is a palindrome, remove all text and 
                //replace with the instructions and the true result string
                if (tester(sentence) == true) {
                    textArea.removeAll();
                    textArea.setText("'"+ sentence +"' is a palindrome");
                  //Otherwise, remove all text, and replace with the instructions
                  //and the false result string
                } else {
                    textArea.removeAll();
                    textArea.setText("'"+ sentence +"' is not a palindrome");
                }//end if/else
                
            }//end actionPerformed  
        });//end actionListener
    }//end constructor
    
    /**
     * tester is a class that takes a string as a parameter, and
     * uses recursive methods to determine whether the string is a palindrome or not.
     * This class will ignore white space, punctuation, and case.
     * 
     * @param sentence
     * @return
     */
    public static boolean tester(String sentence) {
    	
    	    //set count to zero
	        int count = 0;
	         
	        //set backwards count to the length of the sentence
	        int backwardsCount = sentence.length();
	        
	        //change the sentence to lower case for comparisons
	        sentence = sentence.toLowerCase();
	        
	        //first character is stored in first
	        char first = sentence.charAt(count);
	        
	        //last character is stored in last. Be sure to subtract 1
	        //otherwise index will be out of bounds
	        char last = sentence.charAt(backwardsCount - 1);
	       
	        //while the value of the char indicates it is a lower case letter
	        while ( (first < 'a') || (first > 'z')  ) {
	        	
	        	//while sentence has a length of one or zero
	            while (sentence.length() == 0 || sentence.length() == 1) {
	            	//return true
	                return true;
	            }//end while
	            
	            	//otherwise return the string with a substring that
	            	//starts with a new beginning index of 1 rather than zero
	                return tester(sentence.substring(1, sentence.length()));
	        }//end while
	        
	        //while the value of the char indicates it is a lowercase letter
	        while ( (last < 'a') || (last > 'z') ) {
	        	
	        	//while the sentence equals a length of one or zero
	            while (sentence.length() == 0 || sentence.length() == 1) {
	            	
	            	//return true
	                return true;
	            }//end while
	            
	            //otherwise, return the recursive call with a substring that
	            //ends with an index of -1
	            return tester(sentence.substring(0, sentence.length() -1));
	        }//end while
	        
	        //if the sentence is two characters long and tey are the same,
	        //return true, otherwise return false
	        if (sentence.length() == 2) {
	            if (sentence.charAt(0) == sentence.charAt(1)) {
	                return true;
	            }
	            else {
	                return false;
	            }
	        }//end if
	        
	        //if the sentence is of length zero or one, return true
	        if (sentence.length() == 0 || sentence.length() == 1){
	            return true;
	        }//end if
	        
	        //if first letter equals the last letter, return a substring with a
	        //recursive call uses a substring of a starting index of +1,
	        //and an ending index of -1, otherwise return false
	        if (first == last )   {
	                return tester(sentence.substring(1, sentence.length()-1));
	        }//end if
	        
	        return false;
	        
	    }//end tester

    
    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        PalindromeTester window = new PalindromeTester();
    }//end main
    
}//end PalindromeTester
	

