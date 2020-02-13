/*
 * File name: CalculatorViewController.java
 * Author: Shubham Ujinwal, 040885893
 * Course: CST8221 - JAP, Lab Section: 303
 * Assignment: 1, Part-1
 * Date: 18 oct 2018
 * Professor: Daniel Cormier
 * Purpose: This file is responsible for building and operating the calculator GUI.
 * Class list: Controller
 */
package calculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * This class extends JPanel which creates a group of buttons like
 * (radioButtons , checkBox and calculator numeric Keypad buttons).
 * It also contains JTExtField which will display the text of the button pressed by the user.
 * @author Shubham
 * @version 1
 * @see calculator.CalculatorViewController
 * @since 1.8
 */
public class CalculatorViewController extends JPanel{
	/** Swing components are serializable and require serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**Create calculator display1 field reference*/
	private JTextField display1;
	/**Create calculator display2 field reference*/
	private JTextField display2;
	/**Create mode/error display label reference*/
	private JLabel error;
	/**Create button reference*/
	private JButton dotButton;
	private JButton dotButton2;
	/** the radio button reference to help working on clicking multiple times checkBox */
	@SuppressWarnings("unused")
	private JRadioButton doubleJRadioButton; 
	/**Create an array of fixed names for buttons*/
	private final String names[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "\u00B1", "+"};
	/**Create an array of fixed colors for buttons*/
	private final Color colors[]= {Color.BLUE, Color.CYAN, Color.PINK, Color.YELLOW};
	/**Create an array of keyEvents*/
	private static final int keyEvents[] = new int[] {KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_SLASH,

			KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_COMMA, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3,

			KeyEvent.VK_MINUS, KeyEvent.VK_0, KeyEvent.VK_PERIOD, KeyEvent.VK_P, KeyEvent.VK_EQUALS};
	/**create string str user input*/
	private String str = "";
	/**create object of class CalculatorModel*/
	CalculatorModel calc = new CalculatorModel();
	/**create JRadioButton rb2*/
	private JRadioButton rb2= new JRadioButton(".00");
	/**create object of controller class*/
	Controller controller = new Controller();
	/**This default constructor contains the creation of calculator*/
	CalculatorViewController(){

		/*sets the layout of main panel*/
		setLayout(new BorderLayout());
		/*create JPanel header*/
		JPanel headerPanel = new JPanel();
		/*create bottom JPanel which is calculator pad*/
		JPanel bottomPanel = new JPanel();
		/*create JPanel for number pad*/
		JPanel numberPadPanel = new JPanel();
		/*create JPanel which contains number pad panel and clear buttons*/
		JPanel innerPanel = new JPanel();
		/*create JPanel which contains innerPanel and Equal(Enter) buttons*/
		JPanel outerPanel = new JPanel();
		/*create JPanel which contains display1 and display2*/
		JPanel textFieldPanel = new JPanel();
		/*create JPanel for radioButtons*/
		JPanel radioButtonPanel = new JPanel();
		/*create JPanel which contains checkBox*/
		JPanel checkBoxPanel = new JPanel();
		/*create JPanel middle panel which contains checkBoxpanel and radioButtonPanel*/
		JPanel middlePanel = new JPanel();
		/*create Box container*/
		Box modeContainer = Box.createHorizontalBox();
		/*create group of buttons*/
		ButtonGroup buttonGroup = new ButtonGroup();
		
		/*initializes all the JButtons , JLabels and JTextFields */
		display1 = new JTextField();
		display2 = new JTextField("0.0");
		error = new JLabel("F", SwingConstants.CENTER);
		JButton leftEqualbutton = null;
		JButton rightEqualButton = null;
		JButton topClearButton = null;
		JButton buttomClearButton = null;
		JButton backSpaceButton = null;
		JRadioButton rb1 = new JRadioButton(".0");
		//JRadioButton rb2 = new JRadioButton(".00");
		JRadioButton rb3 = new JRadioButton("Sci");
		JCheckBox checkBox = new JCheckBox("Int");
		JButton numberButton = new JButton();
		
		/*set the layout for all the JPanels*/
		headerPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());
		numberPadPanel.setLayout(new GridLayout(4,4,3,3));
		innerPanel.setLayout(new BorderLayout());
		outerPanel.setLayout(new BorderLayout());
		textFieldPanel.setLayout(new GridLayout(2,1));
		checkBoxPanel.setLayout(new BorderLayout());
		radioButtonPanel.setLayout(new BorderLayout());		
		middlePanel.setLayout(new BorderLayout());		
		
		/*set the JPanel border*/
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
		numberPadPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
	
		/*set the size of textField*/
		display1.setPreferredSize(new Dimension(16,30));
		/*set the backGround to white*/
		display1.setBackground(Color.WHITE);
		/*set the columns*/
		display1.setColumns(20);
		/*make the display1 unEditbale*/
		display1.setEditable(false);
		/*align the text to right side in textField*/
		display1.setHorizontalAlignment(SwingConstants.RIGHT);
		/*set the border of textField*/
		display1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		
		/*set the size of textField*/
		display2.setPreferredSize(new Dimension(16,30));
		/*set the backGround to white*/
		display2.setBackground(Color.WHITE);
		/*set the columns*/
		display2.setColumns(20);
		/*make the display1 unEditbale*/
		display2.setEditable(false);
		/*align the text to right side in textField*/
		display2.setHorizontalAlignment(SwingConstants.RIGHT);
		/*set the border of textField*/
		display2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		/*set keyBoard input for backspace*/
		this.getActionMap().put("\u21Da", new KeyActions(backSpaceButton));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "\u21Da");
		
		/*add display1 and display2 in textField panel*/
		textFieldPanel.add(display1);
		textFieldPanel.add(display2);
		
		/*set the backGround color of error button to Yellow*/
		error.setBackground(Color.YELLOW);
		error.setOpaque(true);
		/*set the size of error button*/
		error.setPreferredSize(new Dimension(46,55));
		/*set the font size of error button*/
		error.setFont(new Font("Arial", Font.BOLD, 20));
		/*set the border of error button*/
		error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));
		
		/*initialize the backSpace button and set the text icon*/
		backSpaceButton = new JButton("\u21Da");
		/*set the size of backspace button*/
		backSpaceButton.setPreferredSize(new Dimension (46,55));
		/*set the font size of backspace button text*/
		backSpaceButton.setFont(new Font(getFont().getName(), Font.BOLD, 20));
		/*set the button transparent*/
		backSpaceButton.setOpaque(false);
		backSpaceButton.setContentAreaFilled(false);
		/*add an action listener to backspace button*/
		backSpaceButton.addActionListener(controller);
		/*set the border of the backspace button*/
		backSpaceButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
		/*set the toolTipText text "Backspace Alt-B"*/
		backSpaceButton.setToolTipText("Backspace (Alt-B)");
		/*set the short key*/
		backSpaceButton.setMnemonic(KeyEvent.VK_B);

		/*set the backGround color, add actionListener to the radioButtons*/
		rb1.setBackground(Color.YELLOW);
		rb1.addActionListener(controller);
		rb2.setBackground(Color.YELLOW);
		/*set the radioButton 2 seleted*/
		rb2.setSelected(true);
		rb2.addActionListener(controller);
		rb3.setBackground(Color.YELLOW);
		rb3.addActionListener(controller);
		/*set keyBoard input for radioButtons */
		this.getActionMap().put(".0", new KeyActions(rb1));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_OPEN_BRACKET, 0), ".0");
		this.getActionMap().put(".0", new KeyActions(rb2));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_OPEN_BRACKET, 0), ".00");
		this.getActionMap().put(".0", new KeyActions(rb3));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_OPEN_BRACKET, 0), "Sci");
		
		/*add all the radio Button to radioButtonPanel*/
		radioButtonPanel.add(rb1, BorderLayout.WEST);
		radioButtonPanel.add(rb2, BorderLayout.CENTER);
		radioButtonPanel.add(rb3, BorderLayout.EAST);
		radioButtonPanel.setBorder(BorderFactory.createEmptyBorder());
		
		
		/*set the border,backGround color , size and add actionListener to checkBox*/
		checkBox.setSize(new Dimension(40,0));
		checkBox.setBackground(Color.GREEN);
		checkBox.addActionListener(controller);
		checkBox.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
		this.getActionMap().put("Int", new KeyActions(checkBox));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "Int");
		/*add checkBox to checkBox panel*/
		checkBoxPanel.add(checkBox);
		
		/*Create button group which adds radioButtons and checkBox*/
		buttonGroup.add(rb1);
		buttonGroup.add(rb2);
		buttonGroup.add(rb3);
		buttonGroup.add(checkBox);

		/*Box container add radioButton panel*/
		modeContainer.add(radioButtonPanel);
		
    	middlePanel.add(modeContainer, BorderLayout.EAST);
		middlePanel.add(checkBoxPanel, BorderLayout.WEST);
		/*set the empty border, backGround color of the mode panel*/
		middlePanel.setBackground(Color.BLACK);
		middlePanel.setBorder(new EmptyBorder(10,0,10,0));
		
		/*adding contents to header panel*/
		headerPanel.add(textFieldPanel, BorderLayout.CENTER);
		headerPanel.add(error, BorderLayout.WEST);
		headerPanel.add(backSpaceButton, BorderLayout.EAST);
		headerPanel.add(middlePanel, BorderLayout.SOUTH);
		headerPanel.setBackground(Color.YELLOW);
	
		/*create all the numberPad buttons using createButton method*/
		for(int i=0; i<names.length; i++) {
			/*if the button text is arithmetic then set CYAN color of the button*/
			if(names[i] == "/" || names[i] == "*" || names[i] == "+" || names[i]=="-") {
				numberButton =createButton(names[i], "a", Color.BLACK,	colors[1], controller);
			/*if the button text is +- then set PINK color of the button*/
			}else if(names[i] == "\u00B1"){
				numberButton = createButton(names[i], "a", Color.BLACK,	colors[2], controller);
			}
			/*else sets all the button color to BLUE*/
			else {
				numberButton = createButton(names[i], "a", Color.BLACK,	colors[0], controller);
			}
			
			if(names[i] == ".") 
				dotButton2 = numberButton;
			
			/*set keyBoard input for numpad*/
			this.getActionMap().put(names[i], new KeyActions(dotButton));
			this.getInputMap().put(KeyStroke.getKeyStroke(keyEvents[i], 0), names[i]);	
			
			numberPadPanel.add(numberButton);
		}
		
		/*create equal and clear buttons of the number pad using createButton method*/
		leftEqualbutton = createButton("=", "a", Color.BLACK, colors[3], controller);
		rightEqualButton = createButton("=", "a", Color.BLACK, colors[3], controller);
		topClearButton = createButton("C", "a", Color.BLACK, Color.RED,controller);
		buttomClearButton = createButton("C", "a", Color.BLACK, Color.RED, controller);
		
		/*set keyBoard input for equal and clear buttons*/
		this.getActionMap().put("C", new KeyActions(topClearButton));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
		this.getActionMap().put("C", new KeyActions(buttomClearButton));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
		this.getActionMap().put("=", new KeyActions(leftEqualbutton));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "=");
		this.getActionMap().put("=", new KeyActions(rightEqualButton));
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "=");
		
		/*set the size of the equal and clear buttons*/
		leftEqualbutton.setPreferredSize(new Dimension(46,55));
		rightEqualButton.setPreferredSize(new Dimension(46,55));
		topClearButton.setPreferredSize(new Dimension(0,45));
		buttomClearButton.setPreferredSize(new Dimension(0,45));
		
		/*set border of equal buttons*/
		leftEqualbutton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
		rightEqualButton.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
		
		/*add clear buttons to inner panel*/
		innerPanel.add(topClearButton, BorderLayout.NORTH);
		innerPanel.add(buttomClearButton, BorderLayout.SOUTH);
		
		/*add equal buttons to outer panel*/
		outerPanel.add(leftEqualbutton,BorderLayout.WEST);
		outerPanel.add(rightEqualButton,BorderLayout.EAST);

		innerPanel.add(numberPadPanel, BorderLayout.CENTER);
		outerPanel.add(innerPanel, BorderLayout.CENTER);
		bottomPanel.add(outerPanel);
		
		/*adding all the panels*/
		add(headerPanel, BorderLayout.NORTH);
		add(bottomPanel);

	}
	
	/**
	 * This method creates button with some basic properties and return a 
	 * reference to dotButton.
	 * @param text - sets the text of the string 
	 * @param ac - perform action according to the mode
	 * @param fg - sets the foreGround color of the button
	 * @param bg - sets the backGround color of the button
	 * @param handler - it takes ActionListener object
	 * @return dotButton - it will return JButton reference
	 */
	private JButton createButton (String text, String ac, Color fg, Color bg, ActionListener handler) {
		
		dotButton = new JButton(text);
		dotButton.setForeground(fg);
		dotButton.setBackground(bg);
		/*sets the size of the button*/
		dotButton.setPreferredSize(new Dimension(46,65));
		dotButton.addActionListener(handler);
		/*sets the font size*/
		dotButton.setFont(new Font(getFont().getName(), getFont().getStyle(), 20));
		/*sets an empty border*/
		dotButton.setBorder(BorderFactory.createEmptyBorder());
		
		return dotButton;
	}


	
	/**
	 * This class implements ActionListener
	 * with actionPerformed method which is responsible for performing action
	 * when user press a button.
	 * @author Shubham
	 *
	 */
	private class Controller implements ActionListener{		
		/*
		 * this method will set the text of display2 
		 * to the button text which is pressed by user.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {


			String actionCommand = e.getActionCommand(); 

			int number = -1; 
			/*checks if number is within range*/
			try {

				number = Integer.parseInt (actionCommand); 
			} catch (NumberFormatException e1) { 

			} 
			
			/*adds the string to actionCommand to have more than one digit numbers*/
			if (number >= 0 && calc.getErrorState()== false ) { 

				display2.setText("");

				str += actionCommand; 
				display2.setText(str);

			}  


			/*if the .0 mode is selected */
			if (".0".equals(actionCommand)&& calc.getErrorState()== false ){
				/*if the mode changes to int*/
				if (calc.getMode().equals("Int")){

					str = "";

					display2.setText("0.0");

				} 
				calc.reset();
				error.setText("F");
				display2.setText("0.0");
				calc.setMode(".0");

				error.setBackground(Color.YELLOW); 
				/*enable . button*/
				dotButton2.setEnabled(true);
				dotButton2.setBackground(Color.BLUE);


			/*checks for double point mode*/
			} else if (".00".equals(actionCommand)&& calc.getErrorState()== false){

				/*if the mode changes to int*/
				if (calc.getMode().equals("Int")){ 

					str = "";

					display2.setText("0.0");

				} 
				calc.reset();
				error.setText("F");
				display2.setText("0.0");
				calc.setMode(".00");

				error.setBackground(Color.YELLOW);

				dotButton2.setEnabled(true); // disable dotButton
				dotButton2.setBackground(Color.BLUE);;


			/*checks for Int mode*/
			} else if ("Int".equals(actionCommand)&& calc.getErrorState()== false){
				
				if(error.getText().equals("I")) {
					error.setText("F");
					rb2.setSelected(true);
					error.setBackground(Color.YELLOW);
					error.setOpaque(true);
					calc.setMode("F");
					display1.setText("");
					display2.setText("0.0");
					/*enable . button*/
					dotButton2.setEnabled(true);
					dotButton2.setBackground(Color.BLUE);
					
				}else {
				
				str = "";

				display2.setText("0");
				
				display1.setText("");

				calc.setMode("Int");

				error.setText("I");
				dotButton2.setEnabled(false);
				/*it will disable . operation*/
				error.setBackground(Color.green);
				dotButton2.setBackground(new Color(178,156,250));
				}

			


			/*checks for Sci operation*/
			} else if ("Sci".equals(actionCommand)&& calc.getErrorState()== false){

				/*if the mode changes to Int*/
				if (calc.getMode().equals("Int")){

					str = "";

					display2.setText("0.0");

				} 
				calc.reset();

				calc.setErrorState(false);
				calc.setMode(actionCommand);
				display2.setText("0.0");
				display1.setText("");
				error.setText("F");
				error.setBackground(Color.YELLOW);
				dotButton2.setEnabled(true); 
				dotButton2.setBackground(Color.BLUE);

			} 


			/*checks for + operation*/
			if ("+".equals(actionCommand) && calc.getErrorState()== false){

				display1.setText(actionCommand);

				calc.setArithmeticOp("+");
				/*checks if the string is empty*/
				if(!str.isEmpty()){

					calc.setop1(str); 

					calc.setop2(str);
				}

				display1.setText(calc.getop1()+ "+");

				str = "";


			/*checks for - operation*/
			} else if ("-".equals(actionCommand)&& calc.getErrorState()== false){

				display1.setText(actionCommand);

				calc.setArithmeticOp("-");

				if(!str.isEmpty()){

					calc.setop1(str);

					calc.setop2(str);

				}

				display1.setText(calc.getop1()+ "-");

				str = "";
			/*checks for * operation*/
			} else if ("*".equals(actionCommand)&& calc.getErrorState()== false){

				display1.setText(actionCommand);

				calc.setArithmeticOp("*");	

				if(!str.isEmpty()){

					calc.setop1(str);

					calc.setop2(str);

				}

				display1.setText(calc.getop1()+ "*");

				str = "";


			/*check for division operation*/
			} else if ("/".equals(actionCommand) && calc.getErrorState()== false){	

				display1.setText(actionCommand);

				calc.setArithmeticOp("/");

				if(!str.isEmpty()){

					calc.setop1(str);

					calc.setop2(str);

				}

				display1.setText(calc.getop1()+ "/");

				str = "";


			/*checks for = operation*/
			} else if ("=".equals(actionCommand)&& calc.getErrorState()== false){ 

				/*if = button is clicked then it will do nothing*/
				if ( calc.getTotal().equals("")){

					str = "";

					return;

				}


				/*if any number is divided by zero , generate error*/
				if (calc.getTotal().equals("/") && str.equals("0")){

					if (calc.getop1().equals("0")){

						display2.setText("Result is undefined");

					} else {

						display2.setText("cannot divide by zero");

					}

					error.setText("E");

					error.setBackground(Color.RED);

					calc.setErrorState(true);



				} else {

					if (!str.isEmpty()){

						calc.setop2(str);

					}

					display1.setText("");

					display2.setText((calc.precesion()));

					calc.setop1(calc.precesion());

					str ="";

				}


			/*calls reset method*/
			} else if ("C".equals(actionCommand)){



				if (calc.getMode().equals("Int")){

					display2.setText("0");


				} else {
					display2.setText("0.0");
				}
				
				calc.reset();

				display1.setText("");

				str = "";

				error.setText("F");

				error.setBackground(Color.YELLOW);

				calc.setErrorState(false);

				
			/*delete chars when backSpace is pressed*/
			} else if ("\u21Da".equals(actionCommand)&& calc.getErrorState()== false){ /*backSpace*/

				StringBuilder strB = new StringBuilder(str);

				if (str.length() > 0) {	 



					if(strB.toString().length()== 1 || strB.toString().length()== 2 && display2.getText().contains("-")){ // condition for the last digit if it was < 0

						display2.setText("0.0");
						if(error.getText().equals("I")) 
							display2.setText("0");
						str = "";

					} 

					else {

						strB.deleteCharAt(str.length() - 1); 

						str = strB.toString();

						display2.setText(str);

					}

				} 


			/*checks for . button*/
			} else if (".".equals(actionCommand)&& calc.getErrorState()== false){ 

				if (str.contains(".")){

					return;

				}		



				str += actionCommand; 

				display2.setText(str);



			} else if ("\u00B1".equals(actionCommand)&& calc.getErrorState()== false){ /*plusMinus*/

				if (str.length()==0){

					display2.setText("0");

					display1.setText("negate(0)");

				} 



				if (str.length()> 0){

					StringBuilder strB = new StringBuilder(str);

					if (str.contains("-")){

						strB.deleteCharAt(0);

						str = strB.toString();

						display2.setText(str);

					} else {

						str = "-" + str;

						display2.setText(str);

					}

				}

			}			
		}
	
	}//end of inner class
	
	/**
	 * Create KeyActions class that will accept keyBoard input
	 * @author Shubham
	 */
	private class KeyActions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/** the button to handle keyboard actions */
		AbstractButton button;
		/**
		 * Constructor to take the AbstractAction as a reference
		 * @param button - Abstraction type  
		 */
		public KeyActions(AbstractButton button) {

			this.button = button;

		}
		@Override
		public void actionPerformed(ActionEvent e) {

			button.doClick();

		}

	}
}
