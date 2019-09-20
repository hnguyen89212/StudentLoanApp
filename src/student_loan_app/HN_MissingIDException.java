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
 * Program : HN_MissingIDException.java<br>
 * <p>
 * Description : A class to simulate an exception when user does not specify
 * Student ID.
 * <p>
 * Dependencies : none<br>
 */

public class HN_MissingIDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public HN_MissingIDException() {
		super("Error: ID is missing. Operation aborted.");
	}

}
