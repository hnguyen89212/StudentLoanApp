package student_loan_app;

/**
 * DOCUMENTATION<br>
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
 * Program : HN_LoanPayable.java<br>
 * <p>
 * Description : An interface forcing a method called calculateLoanPayment.<br>
 * <p>
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
