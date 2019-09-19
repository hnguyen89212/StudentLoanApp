package student_loan_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * DOCUMENTATION<br>
 * <br>
 * Author : Hai Nguyen<br>
 * Student ID : 0904995<br>
 * Professor : Madhavi Mohan<br>
 * Class : INFO 3134 S2019<br>
 * Project : Student Loan GUI App<br>
 * Program : RepaymentCalculationForm.java<br>
 * Description : A form to input "current annual interest rate" and
 * "amortization periods in months" to calculate payments.<br>
 * Dependencies : Student.java, StudentLoanApp.java, HN_LoanTools.java,
 * HN_LoanPayable.java, HN_NegativeValueException.java<br>
 */

public class RepaymentCalculationForm extends JFrame {

	// ------------------------------------------
	// CONSTANTS
	// ------------------------------------------
	private static final int WIDTH = 450;
	private static final int HEIGHT = 650;

	// ------------------------------------------
	// INSTANCE VARIABLES
	// ------------------------------------------
	// underlying data structure
	private ArrayList<Student> students;
	private int index;
	// group of labels to display the personal information
	// why use JLabel? because those information need not be changed.
	private JLabel fullName;
	private JLabel fullAddress;
	private JLabel cslLoan;
	private JLabel oslLoan;
	// group of components
	private JTextField primeInterestRateField;
	private JTextField amortizationPeriodInMonthsField;
	private JTextField monthlyCSLPaymentAmountField;
	private JTextField monthlyOSLPaymentAmountField;
	private JTextField totalMonthlyPaymentAmountField;
	private JTextField totalAmountOfRepaidLoanField;
	private JTextField totalAmountBorrowedField;
	private JTextField totalInterestOnLoansField;
	// group of function buttons
	private JButton previousBtn;
	private JButton nextBtn;
	private JButton calculateBtn;
	private JButton clearBtn;

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public RepaymentCalculationForm(ArrayList<Student> list) {
		super("Hai Nguyen's Student Loan App");
		configureBehavior();
		initialize(list);
	}

	// ------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------
	/**
	 * Configures fundamental properties/behaviors of the host frame.
	 */
	private void configureBehavior() {
		this.setLayout(new BorderLayout());
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Initializes all the components, Adds them to correct panels, Adds panels to
	 * host frame
	 * 
	 * @param list an array list storing Student objects
	 */
	private void initialize(ArrayList<Student> list) {
		// underlying data
		this.students = list;
		this.index = 0;

		// NORTH
		this.fullName = new JLabel();
		this.fullAddress = new JLabel();
		this.cslLoan = new JLabel();
		this.oslLoan = new JLabel();
		displayCurrentStudent();
		JPanel panel0 = new JPanel(new GridLayout(4, 2, 2, 2));
		panel0.add(new JLabel("Full Name: "));
		panel0.add(fullName);
		panel0.add(new JLabel("Full Address: "));
		panel0.add(fullAddress);
		panel0.add(new JLabel("Canada Student Loan: "));
		panel0.add(cslLoan);
		panel0.add(new JLabel("Ontario Student Loan: "));
		panel0.add(oslLoan);

		// CENTER
		this.primeInterestRateField = new JTextField();
		this.amortizationPeriodInMonthsField = new JTextField();
		this.monthlyCSLPaymentAmountField = new JTextField();
		this.monthlyOSLPaymentAmountField = new JTextField();
		this.totalMonthlyPaymentAmountField = new JTextField();
		this.totalAmountOfRepaidLoanField = new JTextField();
		this.totalAmountBorrowedField = new JTextField();
		this.totalInterestOnLoansField = new JTextField();
		JPanel panel1 = new JPanel(new GridLayout(8, 2, 2, 2));
		panel1.add(new JLabel("Current prime interest rate: "));
		panel1.add(primeInterestRateField);
		panel1.add(new JLabel("Amortization period in months: "));
		panel1.add(amortizationPeriodInMonthsField);
		panel1.add(new JLabel("Monthly CSL payment amount: "));
		panel1.add(monthlyCSLPaymentAmountField);
		panel1.add(new JLabel("Monthly OSL payment amount: "));
		panel1.add(monthlyOSLPaymentAmountField);
		panel1.add(new JLabel("Total monthly payment amount: "));
		panel1.add(totalMonthlyPaymentAmountField);
		panel1.add(new JLabel("Total amount of your repaid amount: "));
		panel1.add(totalAmountOfRepaidLoanField);
		panel1.add(new JLabel("Total amount you borrowed: "));
		panel1.add(totalAmountBorrowedField);
		panel1.add(new JLabel("Total interest on your loans: "));
		panel1.add(totalInterestOnLoansField);

		// SOUTH
		this.previousBtn = new JButton("Previous");
		this.previousBtn.addActionListener(new GetPreviousStudentListener());
		this.nextBtn = new JButton("Next");
		this.nextBtn.addActionListener(new GetNextStudentListener());
		this.calculateBtn = new JButton("Calculate payments");
		this.calculateBtn.addActionListener(new CalculatePaymentsListener());
		this.clearBtn = new JButton("Clear fields");
		this.clearBtn.addActionListener(new ClearFieldsListener());
		JPanel panel2 = new JPanel(new GridLayout(2, 2, 2, 2));
		panel2.add(this.previousBtn);
		panel2.add(this.nextBtn);
		panel2.add(this.calculateBtn);
		panel2.add(this.clearBtn);

		configureSwitchingButtons();
		// add all panels to frame
		this.add(panel0, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
	}

	/**
	 * Displays personal information of current student (determined by "index") to
	 * the frame.
	 */
	private void displayCurrentStudent() {
		int index = this.index;
		Student student = students.get(index);
		String fullName = student.getFirstName() + " " + student.getMiddlename() + " " + student.getSurname() + ", "
				+ student.getStudentID();
		String fullAddress = student.getAptNumber() + " " + student.getStreetNumber() + " " + student.getStreetName()
				+ " " + student.getCity() + " " + student.getPostalCode() + " " + student.getProvince();
		this.fullName.setText(fullName);
		this.fullAddress.setText(fullAddress);
		this.cslLoan.setText("" + student.getCslLoanAmount());
		this.oslLoan.setText("" + student.getOslLoanAmount());

	}

	/**
	 * Clears all the text fields in frame.
	 */
	private void clearFields() {
		this.primeInterestRateField.setText("");
		this.amortizationPeriodInMonthsField.setText("");
		this.monthlyCSLPaymentAmountField.setText("");
		this.monthlyOSLPaymentAmountField.setText("");
		this.totalMonthlyPaymentAmountField.setText("");
		this.totalAmountOfRepaidLoanField.setText("");
		this.totalAmountBorrowedField.setText("");
		this.totalInterestOnLoansField.setText("");
		// set cursor back to first input (current annual prime interest rate)
		// this.primeInterestRateField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.primeInterestRateField.requestFocus();
	}

	/**
	 * 
	 * @return a double array of 2 elements (months and interest rate)
	 * @throws HN_NegativeValueException
	 */
	private double[] obtainPrimeInterestRateAndAmortizationPeriod() throws HN_NegativeValueException {
		// step 1: ensures that the 2 inputs are not empty
		if (amortizationPeriodInMonthsField.getText().isEmpty() || primeInterestRateField.getText().isEmpty()) {
			HN_LoanTools.showEmptyInputError();
			clearFields();
			return null;
		}
		double[] ret = new double[2];
		// step 2: ensures that numeric values are input
		try {
			ret[0] = Double.parseDouble(amortizationPeriodInMonthsField.getText());
			ret[1] = Double.parseDouble(primeInterestRateField.getText());
		} catch (Exception exc) {
			HN_LoanTools.showNonNumericInputError();
			clearFields();
			return null;
		}
		// step 3: ensures that positive values are input
		if (ret[0] < 0) {
			throw new HN_NegativeValueException("amortization period in months", ret[0]);
		} else if (ret[1] < 0) {
			throw new HN_NegativeValueException("prime interest rate", ret[1]);
		}
		return ret;
	}

	/**
	 * Enables/disables scrolling/switching buttons based on "index". For example,
	 * if the first student is shown, disable "previousBtn".
	 */
	private void configureSwitchingButtons() {
		boolean previousState = (index > 0) ? true : false;
		previousBtn.setEnabled(previousState);
		boolean nextState = (index < students.size() - 1) ? true : false;
		nextBtn.setEnabled(nextState);
	}

	// ------------------------------------------
	// PRIVATE LISTENER CLASSES
	// ------------------------------------------
	/**
	 * Triggered when previous student is needed (previousBtn is clicked)
	 */
	private class GetPreviousStudentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (index > 0)
				index -= 1;
			configureSwitchingButtons();
			clearFields();
			displayCurrentStudent();
		}
	}

	/**
	 * Triggered when next student is needed (nextBtn is clicked)
	 */
	private class GetNextStudentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (index < students.size() - 1)
				index++;
			configureSwitchingButtons();
			clearFields();
			displayCurrentStudent();
		}
	}

	/**
	 * Triggered when clearing form is needed (clearBtn is clicked)
	 */
	private class ClearFieldsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			clearFields();
		}
	}

	/**
	 * Triggered when calculation is needed (calculateBtn is clicked)
	 */
	private class CalculatePaymentsListener implements ActionListener, HN_LoanPayable {
		@Override
		public void actionPerformed(ActionEvent evt) {
			double[] input = { 0.0, 0.0 };
			try {
				input = obtainPrimeInterestRateAndAmortizationPeriod();
				proceedWithPositiveValues(input[0], input[1]);
			} catch (HN_NegativeValueException exc) {
				JFrame fr = new JFrame();
				int option = JOptionPane.showConfirmDialog(fr,
						"Negative value(s) entered. Press OK to convert to positive values to continue.");
				if (option == JOptionPane.YES_OPTION) {
					input[0] = Math.abs(Double.parseDouble(amortizationPeriodInMonthsField.getText()));
					input[1] = Math.abs(Double.parseDouble(primeInterestRateField.getText()));
					amortizationPeriodInMonthsField.setText("" + (int) (input[0]));
					primeInterestRateField.setText("" + input[1]);
					proceedWithPositiveValues(input[0], input[1]);
				} else if (option == JOptionPane.NO_OPTION) {
					clearFields();
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}

		/**
		 * Implements the required method from interface "HN_LoanPayable".
		 */
		@Override
		public double calculateLoanPayment(double studentLoan, double annualPrimeInterestRate,
				int amortPeriodInMonths) {
			return HN_LoanTools.calculateLoanPayment(studentLoan, annualPrimeInterestRate, amortPeriodInMonths);
		}

		/**
		 * 
		 * @param months            amortization period in months
		 * @param primeInterestRate current annual prime interest rate
		 */
		private void proceedWithPositiveValues(double months, double primeInterestRate) {
			// step 4: check if primeInterestRate is in quarter percent increment
			boolean validInterestRate = HN_LoanTools.validateAnnualPrimeInterestRate(primeInterestRate);
			if (!validInterestRate) {
				HN_LoanTools.showAnnualPrimeInterestRateNotInQuarterPercentIncrError();
				clearFields();
				return;
			}
			// get monthly csl payment
			double cslLoanAmount = students.get(index).getCslLoanAmount();
			double monthlyCSLPaymentAmount = calculateLoanPayment(cslLoanAmount,
					primeInterestRate + HN_LoanPayable.CSL_ADDITIONAL_ANNUAL_INTEREST_RATE, (int) months);
			// do rounding
			monthlyCSLPaymentAmount = HN_LoanTools.roundToNearestCent(monthlyCSLPaymentAmount);
			// get monthly osl payment
			double oslLoanAmount = students.get(index).getOslLoanAmount();
			double monthlyOSLPaymentAmount = calculateLoanPayment(oslLoanAmount,
					primeInterestRate + HN_LoanPayable.OSL_ADDITIONAL_ANNUAL_INTEREST_RATE, (int) months);
			// do rounding
			monthlyOSLPaymentAmount = HN_LoanTools.roundToNearestCent(monthlyOSLPaymentAmount);
			// get combined payment
			double combined = monthlyCSLPaymentAmount + monthlyOSLPaymentAmount;
			// do rounding
			combined = HN_LoanTools.roundToNearestCent(combined);
			// set values
			monthlyCSLPaymentAmountField.setText("" + monthlyCSLPaymentAmount);
			monthlyOSLPaymentAmountField.setText("" + monthlyOSLPaymentAmount);
			totalMonthlyPaymentAmountField.setText("" + combined);
			// total money owned, must paid back in the time span
			double totalAmountOfRepaidLoan = combined * months;
			// do rounding
			totalAmountOfRepaidLoan = HN_LoanTools.roundToNearestCent(totalAmountOfRepaidLoan);
			totalAmountOfRepaidLoanField.setText("" + totalAmountOfRepaidLoan);
			// total amount borrowed
			double totalAmountBorrowed = cslLoanAmount + oslLoanAmount;
			totalAmountBorrowedField.setText("" + totalAmountBorrowed);
			// total interest money
			double totalInterestOnLoans = totalAmountOfRepaidLoan - totalAmountBorrowed;
			// do rounding
			totalInterestOnLoans = HN_LoanTools.roundToNearestCent(totalInterestOnLoans);
			totalInterestOnLoansField.setText("" + totalInterestOnLoans);
		}
	}
}
