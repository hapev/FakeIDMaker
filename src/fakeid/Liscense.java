package fakeid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Liscense extends JPanel {
	LocalDate dob;
	JFrame frame;
	LocalDate expiration;
	String height;
	String weight;
	String hair;
	String eyes;
	String sex;
	String name;
	String address;
	String pathChosen;
	BufferedImage template;
	BufferedImage pic;
	Image resizedPic;
	String city;
	String zip;
	String state;
	String fullAddress;

	final Font NORMAL_FONT = new Font("Normal font", Font.ROMAN_BASELINE, 20);
	final Font SMALLER_FONT = new Font("Normal font", Font.ROMAN_BASELINE, 15);
	final Font BIG_FONT = new Font("Normal font", Font.ROMAN_BASELINE, 35);
	final Font HUGE_FONT = new Font("Normal font", Font.BOLD, 65);

	public Liscense(LocalDate dob, LocalDate expiration, String height, String weight, String hair, String eyes,
			String sex, String name, String address, String pathChosen, String city, String zip, String state) {
		this.dob = dob;
		this.expiration = expiration;
		this.height = height;
		this.weight = weight;
		this.hair = hair;
		this.eyes = eyes;
		this.sex = sex;
		this.name = name;
		this.address = address;
		this.pathChosen = pathChosen;
		this.city = city;
		this.zip = zip;
		this.state = state;
		fullAddress = (address + ", " + city + ", " + state + ", " + zip);

		try {
			pic = ImageIO.read(new File(pathChosen));
			resizedPic = pic.getScaledInstance(203, 150, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			template = ImageIO.read(this.getClass().getResourceAsStream("template.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(template, 0, 0, this);
		drawLiscense(g);

	}

	public void drawLiscense(Graphics g) {
		g.drawImage(resizedPic, 0, 0, this);
		g.setFont(NORMAL_FONT);
		g.drawString(dob.toString(), 250, 170);
		g.drawString(expiration.toString(), 475, 170);
		g.drawString(fullAddress, 80, 390);
		g.setFont(SMALLER_FONT);
		g.drawString(height, 280, 240);
		g.drawString(weight, 320, 240);
		g.drawString(hair, 370, 240);
		g.drawString(eyes, 420, 240);
		g.drawString(sex, 480, 240);
		g.setFont(BIG_FONT);
		g.drawString(name, 60, 350);
		Random r = new Random();
		g.setFont(NORMAL_FONT);
		g.drawString(r.nextInt(9999) + "-" + r.nextInt(999) + "-" + r.nextInt(9999), 275, 130);
		g.setFont(HUGE_FONT);

		Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));
		g.setColor(c);

		g.drawString(state, 225, 80);

	}

	// Copyright © 2018 by Evan Coats

}
