/*
 * File name: CalculatorSplashScreen.java
 * Author: Shubham Ujinwal, 040885893
 * Course: CST8221 - JAP, Lab Section: 303
 * Assignment: 1, Part-1
 * Date: 18 oct 2018
 * Professor: Daniel Cormier
 * Purpose: This file is responsible for all the calculations
 * Class list: - 
 */
package calculator;

import java.text.DecimalFormat;


/**
 * this class will do all the calcluations.
 * @author Shubham
 * @version 10.0.2
 * @see calculator.CalculatorSplashScreen
 * @since 1.8
 */
public class CalculatorModel {
	/**create string op1*/
	private String op1= ""; 
	/**create string op2*/
	private String op2= "";
	/**create string mode and initialize it to .00*/
	private String mode= ".00";
	/**create string arith*/
	private String arithmeticOperation = "";
	/**create string op1*/
	private boolean errorState = false;

	/**
	 * it will set operation1
	 * @param op - String type argument
	 */
	public void setop1(String op){ //sets op1

		this.op1 = op;

	}
	/**
	 * it will set operation2
	 * @param op - string type argument
	 */
	public void setop2(String op){ // sets op2

		this.op2 = op;

	}


	/**
	 * it will return operation1 
	 * @return returns op1
	 */
	public String getop1() {

		return op1;

	}
	/**
	 * it will return operation2
	 * @return returns op2
	 */
	public String getop2() { 

		return op2;

	}
	
	/**
	 * it will return the total
	 * @return arithmeticOperation
	 */
	public String getTotal() { // get the total from calculate

		return arithmeticOperation;

	}


	/**
	 * it will return errorState
	 * @return returns errorState
	 */
	public boolean getErrorState(){ 
		return errorState;
	}
	
	/**
	 * it will set the error state
	 * @param state - boolean type
	 */
	public void setErrorState(boolean state){
		this.errorState = state;
	}
	
	/**
	 * it will set the mode
	 * @param mode - String type mode argument
	 */
	public void setMode(String mode){ // sets mode

		this.mode = mode;

	}
	/**
	 * it will return the mode
	 * @return mode
	 */
	public String getMode(){

		return mode;	

	}


	/**
	 * it will set the arithmetic operation
	 * @param arithmeticOp - String type
	 */
	public void setArithmeticOp(String arithmeticOp) {

		this.arithmeticOperation = arithmeticOp;

	}


	/**
	 * it will return the result of op1 and op2 based on the arithmetic operation
	 * @return return result.
	 */
	private float calculate(){
		/*it will check whether op1, op2 and arithmetic operation is emoty or not*/
		if (op1.isEmpty()){

			op1 = "0";

		}

		if(op2.isEmpty()) {

			this.op2 = this.op1;	

		} 

		/*convert op2 to float*/
		if (arithmeticOperation.isEmpty()){ 

			return converToFloat(op2);

		} 

		/*operate arithmetic operations*/
		switch(arithmeticOperation){
		case "+": return converToFloat(op1) + converToFloat(op2); 
		case "-": return converToFloat(op1) - converToFloat(op2); 
		case "*": return converToFloat(op1) * converToFloat(op2); 
		case "/": return converToFloat(op1) / converToFloat(op2); 
		default :
		}

		return 0;

	} 


	/**
	 * gets the format after calling calculate method based on the mode 
	 * @return String - it will return the result in format.
	 */
	public String precesion(){ 
		DecimalFormat format;
		if (mode.equals(".0")){
			format = new DecimalFormat("#0.0");
			return format.format(calculate());

		} else if (mode.equals(".00")){
			format = new DecimalFormat("#0.00") ;
			return format.format(calculate() ) ;

		} else if (("Int".equals(mode))){
			return String.valueOf(Math.round(calculate()));
		} else if (mode.equals("Sci")){
			format = new DecimalFormat("0.#####E00");
			return String.format("%e", Float.parseFloat(Float.toString(calculate())));
		} 
		return "";

	}


	/**
	 * it will reset the calculator
	 */
	public void reset(){
		op1 = "";
		op2 = "";
		arithmeticOperation = "";
	}


	/**
	 * it will convert string to float.
	 * @param n - it takes String type argument.
	 * @return it will return string in float format.
	 */
	public float converToFloat (String n){

		return Float.parseFloat(n);

	}

}


