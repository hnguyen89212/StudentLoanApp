package semester02_Project2_StudentLoanGUIApp;

/**
 * DOCUMENTATION
 * 
 * Author       : Hai Nguyen
 * Student ID   : 0904995
 * Professor    : Madhavi Mohan
 * Class        : INFO 3134 S2019
 * Project      : Student Loan GUI App
 * Program      : HN_NegativeValueException.java
 * Description  : A class to simulate an exception when user enter negative values.
 * Dependencies : none
 */

public class HN_NegativeValueException extends Exception {

    // ------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------
    public HN_NegativeValueException(String str, double negativeValue) {
        super("Error: the field " + str + " cannot have negative value: " + negativeValue);
    }

}
