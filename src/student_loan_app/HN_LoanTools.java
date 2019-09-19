package student_loan_app;

import javax.swing.*;

/**
 * DOCUMENTATION <br>
 * <br>
 * Author : Hai Nguyen <br>
 * Student ID : 0904995 <br>
 * Professor : Madhavi Mohan <br>
 * Class : INFO 3134 S2019 <br>
 * Project : Student Loan GUI App <br>
 * Program : HN_LoanTools.java <br>
 * Description : A class to store helper methods. <br>
 * Dependencies : none <br>
 */

public class HN_LoanTools {

	// ------------------------------------------
	// CONSTANTS
	// ------------------------------------------
	public static final String EMPTY_INPUT_MESSAGE = "Amortization period and annual prime interest rate fields cannot be empty";
	public static final String EMPTY_INPUT_TITLE = "Error on inputs: empty field(s)";
	public static final String NON_NUMERIC_INPUT_MESSAGE = "Amortization period and annual prime interest rate fields can only accept numeric values";
	public static final String NON_NUMERIC_INPUT_TITLE = "Error on inputs: non-numeric value(s)";
	public static final String NOT_IN_QUARTER_PERCENT_INCREMENT_MESSAGE = "Annual prime interest rate must be in quarter percent increments";
	public static final String NOT_IN_QUARTER_PERCENT_INCREMENT_TITLE = "Error on annual prime interest rate";
	private static final int STUDENT_ID_LENGTH = 7;
	private static final String MISSING_INFO_IN_PRIMARY_FORM_MESSAGE = "A field is missing information. All fields except for street number must be filled.";
	private static final String MISSING_INFO_IN_PRIMARY_FORM_TITLE = "Missing Information";
	private static final String NO_RECORD_FOUND_MESSAGE = "Cannot update student: No record found.";
	private static final String NO_RECORD_FOUND_TITLE = "No matching record.";

	/**
	 * Validates the input in "current annual prime interest rate".
	 * 
	 * @param rate current annual prime interest rate
	 * @return true if the rate is ended in ".00", ".25", ".50" or ".75"; false,
	 *         otherwise
	 */
	public static boolean validateAnnualPrimeInterestRate(double rate) {
		int a = (int) (Math.floor(rate)) * 100;
		int b = (int) (rate * 100);
		int c = (a > b) ? a - b : b - a;
		// System.out.println(a + " " + b + " " + c);
		if (c == 0 || c == 25 || c == 50 || c == 75)
			return true;
		else
			return false;
	}

	/**
	 * Validates student ID.
	 * 
	 * @param id A string representing an ID
	 * @return true if id is 7-character long, digit-only; false, otherwise
	 */
	public static boolean validateStudentID(String id) {
		if (id.length() != STUDENT_ID_LENGTH)
			return false;
		for (int i = 0; i < id.length(); i++)
			if (!Character.isDigit(id.charAt(i)))
				return false;
		return true;
	}

	/**
	 * Calculates monthly payment for CSL or OSL (NOT both).
	 * 
	 * @param studentLoan             the amount owed
	 * @param annualPrimeInterestRate annual interest rate
	 * @param amortPeriodInMonths     time span to pay back, in months
	 * @return
	 */
	public static double calculateLoanPayment(double studentLoan, double annualPrimeInterestRate,
			int amortPeriodInMonths) {
		double monthlyInterestRate = annualPrimeInterestRate * HN_LoanPayable.ANNUAL_RATE_TO_MONTHLY_RATE;
		double numerator = studentLoan * monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, amortPeriodInMonths));
		double denumerator = (Math.pow(1 + monthlyInterestRate, amortPeriodInMonths) - 1);
		return numerator / denumerator;
	}

	/**
	 * Rounds a double to 2 decimals.
	 * 
	 * @param amount
	 * @return
	 */
	public static double roundToNearestCent(double amount) {
		double ret = amount * 100.0;
		ret += 0.5;
		return ((int) (ret)) / 100.0;
	}

	/**
	 * Displays a JOptionPane showing certain kind of error message.
	 * 
	 * @param message the message we want to send
	 * @param title   the title of the JOptionPane
	 */
	public static void showErrorMessage(String message, String title) {
		JFrame fr = new JFrame();
		JOptionPane.showMessageDialog(fr, message, title, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Declares that interest rate is not in quarter increments.
	 */
	public static void showAnnualPrimeInterestRateNotInQuarterPercentIncrError() {
		showErrorMessage(NOT_IN_QUARTER_PERCENT_INCREMENT_MESSAGE, NOT_IN_QUARTER_PERCENT_INCREMENT_TITLE);
	}

	/**
	 * Declares that inputs are empty.
	 */
	public static void showEmptyInputError() {
		showErrorMessage(EMPTY_INPUT_MESSAGE, EMPTY_INPUT_TITLE);
	}

	/**
	 * Informs that non-numeric values are entered.
	 */
	public static void showNonNumericInputError() {
		showErrorMessage(NON_NUMERIC_INPUT_MESSAGE, NON_NUMERIC_INPUT_TITLE);
	}

	public static void showMissingInfoInPrimaryForm() {
		showErrorMessage(MISSING_INFO_IN_PRIMARY_FORM_MESSAGE, MISSING_INFO_IN_PRIMARY_FORM_TITLE);
	}

	public static void showNoRecordFoundError() {
		showErrorMessage(NO_RECORD_FOUND_MESSAGE, NO_RECORD_FOUND_TITLE);
	}

}
