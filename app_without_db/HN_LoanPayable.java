package semester02_Project2_StudentLoanGUIApp;

/**
 * DOCUMENTATION
 * 
 * Author       : Hai Nguyen
 * Student ID   : 0904995
 * Professor    : Madhavi Mohan
 * Class        : INFO 3134 S2019
 * Project      : Student Loan GUI App
 * Program      : HN_LoanPayable.java
 * Description  : An interface forcing a method called calculateLoanPayment.
 * Dependencies : none
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
