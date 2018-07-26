package fakeid;

import java.io.File;
import java.time.LocalDate;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Reciever {
	LocalDate dob;
	LocalDate expiration;
	String height;
	String weight;
	String hair;
	String eyes;
	String sex;
	String name;
	String address;
	File photoChosen;
	String pathChosen;
	String state;
	String city;
	String zip;
	
	
	
	public void recieveData(){
	JOptionPane.showMessageDialog(null, "Questions will now be asked to set up your fake drivers liscense.");
	dob = LocalDate.of(Integer.parseInt(JOptionPane.showInputDialog("What year were you born?")), 
			Integer.parseInt(JOptionPane.showInputDialog("What month were you born? (Number)")),
			Integer.parseInt(JOptionPane.showInputDialog("What day were you born?")));	
	expiration = LocalDate.of(LocalDate.now().getYear()+5, dob.getMonthValue(), dob.getDayOfMonth());

		height = JOptionPane.showInputDialog("What is your height?");

		weight = JOptionPane.showInputDialog("What is your weight?");

		hair = JOptionPane.showInputDialog("What is your hair color (Two letters)(For Example: Brown is BR and Blond is BL)?");

		eyes = JOptionPane.showInputDialog("What is your eye color (Two letters)(For Example: Brown is BR and Blue is BL)?");

		sex = JOptionPane.showInputDialog("What is your sex? (M or F)");

		name = JOptionPane.showInputDialog("What is your full name?");

		address = JOptionPane.showInputDialog("What is your address?");

		city = JOptionPane.showInputDialog("What city are you from?");
		zip = JOptionPane.showInputDialog("What is your zip code?");
		state = JOptionPane.showInputDialog("What state are you from? (No Abreviation)");
		JOptionPane.showMessageDialog(null, "You will now be prompted for a picture of you.");
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		photoChosen = chooser.getSelectedFile();
		pathChosen = photoChosen.getAbsolutePath();
		JOptionPane.showMessageDialog(null, "Your fake driver's lisense will now be set up.");
		create();

		
		
		
	}	
	
	public void create() {
		JFrame frame = new JFrame();

		
		Liscense l = new Liscense(dob,expiration,height,weight,hair,eyes,sex,name,address,pathChosen,city,zip,state);
		frame.add(l);
		frame.setSize(700,450);
		l.setSize(700, 450);
				frame.setVisible(true);
		

	
	
	
				//Copyright © 2018 by Evan Coats
	
	}
	
	
	
	
	
	
}
