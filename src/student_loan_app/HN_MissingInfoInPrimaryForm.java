package student_loan_app;

public class HN_MissingInfoInPrimaryForm extends Exception {
	
	// ------------------------------------------
		// CONSTRUCTOR
		// ------------------------------------------
		public HN_MissingInfoInPrimaryForm() {
			super("Error: A field is missing information. All fields except for street number must be filled.");
		}

}
