package student_loan_app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;
import back_end_db.StudentDB;

/**
 * DOCUMENTATION<br>
 * <br>
 * Author : Hai Nguyen<br>
 * Student ID : 0904995<br>
 * Professor : Madhavi Mohan<br>
 * Class : INFO 3134 S2019<br>
 * Project : Student Loan GUI App<br>
 * Program : StudentLoanApp.java<br>
 * Description : A form to add new students to storage, trigger source for
 * RepaymentCalculationForm.<br>
 * Dependencies : Student.java<br>
 */

public class StudentLoanApp extends JFrame {

	// ------------------------------------------
	// CONSTANTS
	// ------------------------------------------
	private static final String AUTHOR = "Hai Nguyen";
	private static final String STUDENT_ID = "0904995";
	private static final int WIDTH = 450;
	private static final int HEIGHT = 650;

	// ------------------------------------------
	// INSTANCE VARIABLES
	// ------------------------------------------
	// title bar
	private JLabel titleLabel;
	// studentid
	private JTextField studentIDInput;
	// surname, lastname
	private JTextField surnameInput;
	// middle name
	private JTextField middlenameInput;
	// first name
	private JTextField firstnameInput;
	// apartment number
	private JTextField aptNumberInput;
	// street number
	private JTextField streetNumberInput;
	// street name
	private JTextField streetNameInput;
	// city
	private JTextField cityInput;
	// province
	private JTextField provinceInput;
	// postal code
	private JTextField postalcodeInput;
	// csl
	private JTextField cslInput;
	// osl
	private JTextField oslInput;
	// function buttons
	private JButton addStudentBtn;
	private JButton clearInputBtn;
	private JButton processStudentBtn;
	// message board
	private JLabel messageBoardLabel;
	// main panel
	private JPanel mainPanel;
	// check button, to verify existence of user
	private JButton checkIDBtn;
	// update button, to change student info
	private JButton updateStudentBtn;
	// delete button, to remove student
	private JButton deleteStudentBtn;

	// ------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------
	public StudentLoanApp() {
		super("" + AUTHOR + " " + STUDENT_ID);
		configureBehavior();
		initialize();
	}

	// ------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------
	/**
	 * Configures fundamental properties/behaviors of the host frame.
	 */
	private void configureBehavior() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Initializes all the components, Adds them to correct panels, Adds panels to
	 * host frame
	 */
	private void initialize() {
		this.titleLabel = new JLabel("This is " + AUTHOR + "'s Student Loan Calculator");
		JPanel panel0 = new JPanel();
		panel0.add(this.titleLabel);

		this.studentIDInput = new JTextField();
		this.surnameInput = new JTextField();
		this.middlenameInput = new JTextField();
		this.firstnameInput = new JTextField();
		this.aptNumberInput = new JTextField();
		this.streetNumberInput = new JTextField();
		this.streetNameInput = new JTextField();
		this.cityInput = new JTextField();
		this.provinceInput = new JTextField();
		this.postalcodeInput = new JTextField();
		this.cslInput = new JTextField();
		this.oslInput = new JTextField();

		this.addStudentBtn = new JButton("Add");
		this.addStudentBtn.addActionListener(new AddStudentListener());
		this.clearInputBtn = new JButton("Clear Form");
		this.clearInputBtn.addActionListener(new ClearFormListener());
		this.processStudentBtn = new JButton("Process");
		this.processStudentBtn.addActionListener(new ProcessStudentListener());
		this.checkIDBtn = new JButton("Check Student in DB");
		this.checkIDBtn.addActionListener(new CheckStudentIDListener());
		this.updateStudentBtn = new JButton("Update Student");
		this.updateStudentBtn.addActionListener(new UpdateStudentListener());
		//
		this.deleteStudentBtn = new JButton("Delete Student");

		JPanel panel1 = new JPanel(new GridLayout(14, 2, 2, 2)); // one new row added for "Check" button
		panel1.add(new JLabel("Student ID: "));
		panel1.add(this.studentIDInput);
		panel1.add(new JLabel("Check Student ID:"));
		panel1.add(this.checkIDBtn);
		panel1.add(new JLabel("Surname: "));
		panel1.add(this.surnameInput);
		panel1.add(new JLabel("Middle name: "));
		panel1.add(this.middlenameInput);
		panel1.add(new JLabel("First name: "));
		panel1.add(this.firstnameInput);
		panel1.add(new JLabel("Apt number: "));
		panel1.add(this.aptNumberInput);
		panel1.add(new JLabel("Street number: "));
		panel1.add(this.streetNumberInput);
		panel1.add(new JLabel("Street name: "));
		panel1.add(this.streetNameInput);
		panel1.add(new JLabel("City: "));
		panel1.add(this.cityInput);
		panel1.add(new JLabel("Province: "));
		panel1.add(this.provinceInput);
		panel1.add(new JLabel("Postal code: "));
		panel1.add(this.postalcodeInput);
		panel1.add(new JLabel("CSL: "));
		panel1.add(this.cslInput);
		panel1.add(new JLabel("OSL: "));
		panel1.add(this.oslInput);
		panel1.add(this.updateStudentBtn);
		panel1.add(this.deleteStudentBtn);

		JPanel panel2 = new JPanel(new GridLayout(1, 3, 2, 2));
		panel2.add(this.addStudentBtn);
		panel2.add(this.clearInputBtn);
		panel2.add(this.processStudentBtn);

		JPanel panel012 = new JPanel(new BorderLayout());
		panel012.add(panel0, BorderLayout.NORTH);
		panel012.add(panel1, BorderLayout.CENTER);
		panel012.add(panel2, BorderLayout.SOUTH);

		JPanel panel3 = new JPanel();
		this.messageBoardLabel = new JLabel("Welcome");
		panel3.add(this.messageBoardLabel);

		this.mainPanel = new JPanel(new BorderLayout());
		this.mainPanel.add(panel012, BorderLayout.CENTER);
		this.mainPanel.add(panel3, BorderLayout.SOUTH);

		this.add(this.mainPanel);
		this.studentIDInput.requestFocus();
	}

	/**
	 * Clears the message board.
	 */
	private void clearMessageBoard() {
		this.messageBoardLabel.setText("");
	}

	/**
	 * Clears all text fields.
	 */
	private void clearInput() {
		this.studentIDInput.setText("");
		clearInputExceptID();
		this.studentIDInput.requestFocus();
	}

	private void clearInputExceptID() {
		this.surnameInput.setText("");
		this.middlenameInput.setText("");
		this.firstnameInput.setText("");
		this.aptNumberInput.setText("");
		this.streetNumberInput.setText("");
		this.streetNameInput.setText("");
		this.cityInput.setText("");
		this.provinceInput.setText("");
		this.postalcodeInput.setText("");
		this.cslInput.setText("");
		this.oslInput.setText("");
	}

	/**
	 * Validate inputs in primary form Every field must be filled except for street
	 * number
	 * 
	 * @throws HN_MissingInfoInPrimaryForm
	 */
	private void validatePrimaryForm() throws HN_MissingInfoInPrimaryForm {
		boolean passed = (!this.studentIDInput.getText().isEmpty() && !this.surnameInput.getText().isEmpty()
				&& !this.middlenameInput.getText().isEmpty() && !this.firstnameInput.getText().isEmpty()
				&& !this.aptNumberInput.getText().isEmpty() && !this.streetNameInput.getText().isEmpty()
				&& !this.cityInput.getText().isEmpty() && !this.provinceInput.getText().isEmpty()
				&& !this.postalcodeInput.getText().isEmpty() && !this.cslInput.getText().isEmpty()
				&& !this.oslInput.getText().isEmpty());
		if (!passed) {
			HN_LoanTools.showMissingInfoInPrimaryForm();
			throw new HN_MissingInfoInPrimaryForm();
		}
	}

	/**
	 * Adds a student to storage.
	 */
	private void addStudent() {
		try {
			String id = this.studentIDInput.getText();
			boolean validID = HN_LoanTools.validateStudentID(id);
			if (!validID)
				throw new Exception("Invalid Student ID");
			String student_id = this.studentIDInput.getText();
			String surname = this.surnameInput.getText();
			String middlename = this.middlenameInput.getText();
			String firstname = this.firstnameInput.getText();
			int aptnumber = Integer.parseInt(this.aptNumberInput.getText());
			int streetnumber;
			if (this.streetNumberInput.getText().isEmpty()) {
				streetnumber = 0;
			} else {
				streetnumber = Integer.parseInt(this.streetNumberInput.getText());
			}
			String streetname = this.streetNameInput.getText();
			String city = this.cityInput.getText();
			String province = this.provinceInput.getText();
			String postalcode = this.postalcodeInput.getText();
			double csl = Double.parseDouble(this.cslInput.getText());
			double osl = Double.parseDouble(this.oslInput.getText());
			// add to db
			StudentDB.addNewStudent(student_id, surname, middlename, firstname, aptnumber, streetnumber, streetname,
					city, province, postalcode, csl, osl);
			this.messageBoardLabel.setText("Student is successfully added!");
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			this.messageBoardLabel.setText("Something went wrong! Try again!");
		} finally {
			clearInput();
		}
	}

	private void updateStudent() {
		try {
			String id = this.studentIDInput.getText();
			boolean validID = HN_LoanTools.validateStudentID(id);
			if (!validID)
				throw new Exception("Invalid Student ID");
			String student_id = this.studentIDInput.getText();
			String surname = this.surnameInput.getText();
			String middlename = this.middlenameInput.getText();
			String firstname = this.firstnameInput.getText();
			int aptnumber = Integer.parseInt(this.aptNumberInput.getText());
			int streetnumber;
			if (this.streetNumberInput.getText().isEmpty()) {
				streetnumber = 0;
			} else {
				streetnumber = Integer.parseInt(this.streetNumberInput.getText());
			}
			String streetname = this.streetNameInput.getText();
			String city = this.cityInput.getText();
			String province = this.provinceInput.getText();
			String postalcode = this.postalcodeInput.getText();
			double csl = Double.parseDouble(this.cslInput.getText());
			double osl = Double.parseDouble(this.oslInput.getText());
			// update new info in db
			boolean success = StudentDB.updateStudent(student_id, surname, middlename, firstname, aptnumber,
					streetnumber, streetname, city, province, postalcode, csl, osl);
			if (!success) {
				this.messageBoardLabel.setText("Something went wrong! Try again!");
			} else {
				this.messageBoardLabel.setText("Student is successfully updated!");
			}
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			this.messageBoardLabel.setText("Something went wrong! Try again!");
		} finally {
			clearInput();
		}
	}

	// ------------------------------------------
	// PRIVATE LISTENER CLASSES
	// ------------------------------------------
	private class AddStudentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			clearMessageBoard();
			try {
				validatePrimaryForm();
			} catch (HN_MissingInfoInPrimaryForm e) {
				e.printStackTrace();
				return;
			}
			addStudent();
		}
	}

	private class ClearFormListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			clearMessageBoard();
			clearInput();
		}
	}

	private class ProcessStudentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {

		}
	}

	private class CheckStudentIDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String idInput = studentIDInput.getText();
			ResultSet rs = StudentDB.checkStudentId(idInput);
			int rowCount = 0;
			try {
				// determine number of rows
				if (rs.last()) {
					rowCount = rs.getRow();
					rs.beforeFirst();
				}
				if (rowCount > 0) {
					// reset cursor to first set
					rs.first();
					addStudentBtn.setEnabled(false);
					surnameInput.setText(rs.getString("surname"));
					middlenameInput.setText(rs.getString("middle_name"));
					firstnameInput.setText(rs.getString("first_name"));
					aptNumberInput.setText(rs.getString("apt_number"));
					streetNumberInput.setText(rs.getString("street_number"));
					streetNameInput.setText(rs.getString("street_name"));
					cityInput.setText(rs.getString("city"));
					provinceInput.setText(rs.getString("province"));
					postalcodeInput.setText(rs.getString("postal_code"));
					cslInput.setText(rs.getString("csl_loan_amount"));
					oslInput.setText(rs.getString("osl_loan_amount"));
					;
					messageBoardLabel.setText("Student already exists in database.");
				} else {
					addStudentBtn.setEnabled(true);
					messageBoardLabel.setText("Student does not exist in database.");
					clearInputExceptID();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private class UpdateStudentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			clearMessageBoard();
			try {
				validatePrimaryForm();
			} catch (HN_MissingInfoInPrimaryForm e) {
				e.printStackTrace();
				return;
			}
			updateStudent();
		}
	}
}

// 0904995