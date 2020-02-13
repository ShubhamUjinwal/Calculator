/*
 * File name: Calculator.java
 * Author: Shubham Ujinwal, 040885893
 * Course: CST8221 - JAP, Lab Section: 303
 * Assignment: 1, Part-1
 * Date: 18 oct 2018
 * Professor: Daniel Cormier
 * Purpose: This file is responsible for launching program.
 * Class list: - 
 */
package calculator;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * This main class is responsible for creation of splash screen window and JFrame. 
 * @author Shubham
 * @version 1
 * @see calculator.Calculator
 * @since 1.8
 */

public class Calculator{
	/**
	 * This main method contains CalculatorSplashScreen object which calls
	 * showSplashWindow() and displays splashScreen for 5 seconds.
	 * Then it call EventQueue.invokeLater() method with a Runnable instance run() method 
	 * which creates JFrame and set the content pane to CalculatorViewController object.
	 *  
	 * @param args - takes String type arguments.
	 */
	public static void main(String[] args) {
		
		/*Creates an object of CalculatorSplashScreen which 
		 * takes argument for the duration of splashscreen*/
		CalculatorSplashScreen splashScreen = new CalculatorSplashScreen(5000);
		splashScreen.showSplashWindow();
		
		/*calling EventQueue.invokeLater() method with Runnable instance run method which
		 * creates JFrame when splash screen is closed*/
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				/*Creates JFrame named calculator.*/
				JFrame frame = new JFrame("Calculator");
				/*create an object of CalculatorViewController class*/
				CalculatorViewController controller = new CalculatorViewController();
				/*set the content pane to CalculatorViewController object*/
				frame.setContentPane(controller);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				/*set the minimum size of JFrame.*/
				frame.setMinimumSize(new Dimension(380, 520));
				frame.getContentPane();
				frame.setVisible(true);	
			}
		});
	}
}
