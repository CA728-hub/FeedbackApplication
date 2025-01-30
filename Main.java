import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;



public class Main {
	
	public static void main(String[] args) {
		ArrayList<StudentInformation> students = new ArrayList<>(); //ArrayList created to store data from Student entry.
		
		//GUI Creation
		JFrame frame = new JFrame();
		JTextField fieldOne = new JTextField("Name", 20);
		JTextField fieldTwo = new JTextField("Feedback", 20); 
		JButton view = new JButton(); 
		JButton save = new JButton(); 
		
		
		
	
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student Information");
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		frame.add(fieldOne);
		frame.add(fieldTwo);
		frame.add(view); 
		frame.add(save); 
	
		
		view.setText("View feedback"); 
		save.setText("Save");
		
		
		frame.setVisible(true);
		
		
		//Button method for when the user wants to view the txt file. 
		view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		
            		FileReader fileR = new FileReader("feedback.txt"); 
            		StringBuilder content = new StringBuilder();
            		
            		int character;
                    while ((character = fileR.read()) != -1) {
                    	content.append((char) character);
                    } 
                    
                    fileR.close(); 
                    
                    JOptionPane.showMessageDialog(null, content.toString(), "File Content", JOptionPane.INFORMATION_MESSAGE);
                    
       
            	} catch (IOException m) {
            		JOptionPane.showMessageDialog(null, "Error reading file: " + m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            	}
            	
            	
               
            }
        });
		
		
		//Button method for when the user wants to save the txt file. 
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String view = fieldOne.getText();
            	String save = fieldTwo.getText(); 
            	
            	try { //try statements included to catch catches. 
        			String text = fieldOne.getText();
        			String textTwo = fieldTwo.getText(); 
        			
        			
        			File fileE = new File("feedback.txt"); 
        			
        			if (fileE.exists()) {
        				
        				FileWriter fileWriter = new FileWriter(fileE, true);
        				fileWriter.write(" " + text);
            			fileWriter.write(" " + textTwo);
            			fileWriter.close(); 
            			
            			JOptionPane.showMessageDialog(null, "Information successfully saved!", null, JOptionPane.INFORMATION_MESSAGE);
        				
        			}  else {
        				
        				FileWriter fileWriterTwo = new FileWriter("feedback.txt");
        				fileWriterTwo.write(" " + text);
        				fileWriterTwo.write(" " + textTwo);
        				fileWriterTwo.close(); 
        				
        				JOptionPane.showMessageDialog(null, "Information successfully saved!", null, JOptionPane.INFORMATION_MESSAGE);
        			}
        			
        			StudentInformation newData = new StudentInformation(view, save);
        			
        			students.add(newData);
        			
        			
        		} catch (IOException s) { 
        			JOptionPane.showMessageDialog(null, "Error saving file: " + s.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        		}
            	
            	
            }
        });
		
	}
}




//Student class created to turn into an object to create an Array to store updated student data. 
class StudentInformation {
	
	String name;
	String feedback;
	
	StudentInformation(String name, String feedback) {
		this.name = name;
		this.feedback = feedback;
	}
}
