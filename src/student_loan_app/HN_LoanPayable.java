package student_loan_app;

/**
 * DOCUMENTATION<br>
 * <br>
 * Author : Hai Nguyen<br>
 * Student ID : 0904995<br>
 * Professor : Madhavi Mohan<br>
 * Class : INFO 3134 S2019<br>
 * Project : Student Loan GUI App<br>
 * Program : HN_LoanPayable.java<br>
 * Description : An interface forcing a method called calculateLoanPayment.<br>
 * Dependencies : none<br>
 */

public interface HN_LoanPayable {

	// ------------------------------------------
	// CONSTANTS
	// ------------------------------------------
	public static final double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0 / 1200;
	public static final double CSL_ADDITIONAL_ANNUAL_INTEREST_RATE = 2.5;
	public static final double OSL_ADDITIONAL_ANNUAL_INTEREST_RATE = 1.0;

	/**
	 * 
	 * @param studentLoan
	 * @param annualPrimeInterestRate
	 * @param amortPeriodInMonths
	 * @return
	 */
	public abstract double calculateLoanPayment(double studentLoan, double annualPrimeInterestRate,
			int amortPeriodInMonths);

}
