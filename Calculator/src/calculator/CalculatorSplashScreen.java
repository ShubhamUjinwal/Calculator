/*
 * File name: CalculatorSplashScreen.java
 * Author: Shubham Ujinwal, 040885893
 * Course: CST8221 - JAP, Lab Section: 303
 * Assignment: 1, Part-1
 * Date: 18 oct 2018
 * Professor: Daniel Cormier
 * Purpose: This file is responsible for the creation of splash screen window.
 * Class list: - 
 */
package calculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * This class displays a splash screen which contains an image 
 * and author name and student number at the bottom of the window.
 * @author Shubham
 * @version 10.0.2
 * @see calculator.CalculatorSplashScreen
 * @since 1.8
 */
public class CalculatorSplashScreen extends JWindow{
	 /** Swing components are serializable and require serialVersionUID */
	private static final long serialVersionUID = 1L;
	 /** Splash screen duration */
	private final int duration;
	/**
	 * this parameter sets the duration of the splash screen.
	 * @param duration - takes an integer type parameter which sets the duration time.
	 */
	public CalculatorSplashScreen(int duration) {
		this.duration = duration;
	}
	
	/**
	 Shows a splash screen in the center of the desktop
	 for the amount of time given in the constructor.
	*/
	public void showSplashWindow() {
		/*create content pane*/
		JPanel content = new JPanel(new BorderLayout());
	    /*create panel for progress bar*/
		JPanel panel = new JPanel(new BorderLayout());
		JProgressBar progress = new JProgressBar();
		JLabel progressLabel = new JLabel("Loading Calculator.Please wait...");
		/*set background color*/
		content.setBackground(Color.RED);
		panel.setOpaque(false);
		/*set progress bar*/
		progress.setMinimum(0);
		progress.setMaximum(duration);
		progress.setBackground(Color.WHITE);
		progress.setForeground(Color.BLUE);
		progress.setPreferredSize(new Dimension(10, 20));

		progressLabel.setForeground(Color.WHITE);
		progressLabel.setHorizontalAlignment(JLabel.CENTER);
		progressLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        progressLabel.setOpaque(false);

		

        /** To add processBar into panel */
        panel.add(progress, BorderLayout.NORTH);
        panel.add(progressLabel, BorderLayout.SOUTH);
		
	    /* Set the window's bounds, position the window in the center of the screen*/
	    int width =  534+50;
	    int height = 263+50;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    /*set the location and the size of the window*/
	    setBounds(x,y,width,height);
	    
	    /*using URL with an image placed in resources folder in source folder
	  	accessing an image in the calculator package*/
	    JLabel label = new JLabel(new ImageIcon(getClass().getResource("a.jpg")));     
	    JLabel demo = new JLabel("Shubham Ujinwal, 040885893", JLabel.CENTER);
	    demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
	    
	    content.add(panel,BorderLayout.NORTH);
	    content.add(label, BorderLayout.CENTER);
	    content.add(demo, BorderLayout.SOUTH);
	    /*create custom RGB color*/
	    Color customColor = new Color(44, 197, 211);
	    content.setBorder(BorderFactory.createLineBorder(customColor, 10));
	    /*Replace the window content panel with JPanel*/
	    setContentPane(content);
	    /*make the splash window visible*/
	    setVisible(true);
	    /* Wait a little while doing nothing, while the application is loading*/
	    try {	
	    	
	    	for(int i=0; i<duration; i++) {
	    		progress.setValue(i);
	    		Thread.sleep(1); 
	    	}
	    	 
	    }
	    catch (InterruptedException e) {e.printStackTrace();}
	    /*destroy the window and release all resources*/
	    dispose(); 
	    
	}
}
