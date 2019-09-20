package student_loan_app;

/**
 * DOCUMENTATION <br>
 * <p>
 * Author : Hai Nguyen<br>
 * <p>
 * Student ID : 0904995<br>
 * <p>
 * Professor : Madhavi Mohan<br>
 * <p>
 * Class : INFO 3134 S2019<br>
 * <p>
 * Project : Student Loan GUI App<br>
 * <p>
 * Program : HN_NegativeValueException.java<br>
 * <p>
 * Description : A class to simulate an exception when user enter negative
 * values.<br>
 * <p>
 * Dependencies : none<br>
 */

public class HN_NegativeValueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public HN_NegativeValueException(String str, double negativeValue) {
		super("Error: the field " + str + " cannot have negative value: " + negativeValue);
	}

}
