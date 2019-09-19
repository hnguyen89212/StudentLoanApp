package student_loan_app;

/**
 * DOCUMENTATION <br>
 * <br>
 * Author : Hai Nguyen<br>
 * Student ID : 0904995<br>
 * Professor : Madhavi Mohan<br>
 * Class : INFO 3134 S2019<br>
 * Project : Student Loan GUI App<br>
 * Program : HN_NegativeValueException.java<br>
 * Description : A class to simulate an exception when user enter negative
 * values.<br>
 * Dependencies : none<br>
 */

public class HN_NegativeValueException extends Exception {

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public HN_NegativeValueException(String str, double negativeValue) {
		super("Error: the field " + str + " cannot have negative value: " + negativeValue);
	}

}
