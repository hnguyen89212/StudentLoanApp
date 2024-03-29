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
 * Program : HN_MissingInfoInPrimaryForm.java<br>
 * <p>
 * Description : A class to simulate an exception when user does not input for
 * any text field other than street number (they are required, except for street
 * number).
 * <p>
 * Dependencies : none<br>
 */

public class HN_MissingInfoInPrimaryForm extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public HN_MissingInfoInPrimaryForm() {
		super("Error: A field is missing information. All fields except for street number must be filled.");
	}

}
