package semester02_Project2_StudentLoanGUIApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * DOCUMENTATION
 * 
 * Author       : Hai Nguyen
 * Student ID   : 0904995
 * Professor    : Madhavi Mohan
 * Class        : INFO 3134 S2019
 * Project      : Student Loan GUI App
 * Program      : StudentLoanApp.java
 * Description  : A form to add new students to storage, trigger source for RepaymentCalculationForm.
 * Dependencies : Student.java
 */

public class StudentLoanApp extends JFrame {

    // ------------------------------------------
    // DUMMY DATA SET FOR TESTING
    // ------------------------------------------
    private static Student s1 = new Student("0904995", "Nguyen", "Phuc", "Hai", "342", "123", "Okanagan", "London",
            "Ontario", "N5X 4Y3", 2500.0, 1500);
    private static Student s2 = new Student("0087901", "Le", "Nhat", "Minh", "460", "437", "Beckworth", "Guelph",
            "Ontario", "M6R 0T5", 23400.0, 12.34);

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
    // storage
    private ArrayList<Student> students;
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
     * Initializes all the components,
     * Adds them to correct panels,
     * Adds panels to host frame
     */
    private void initialize() {
        this.students = new ArrayList<Student>();
        // --------------------------------------
        // FOR DEBUGGING
        // --------------------------------------
        this.students.add(s1);
        this.students.add(s2);

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
        JPanel panel1 = new JPanel(new GridLayout(12, 2, 2, 2));
        panel1.add(new JLabel("Student ID: "));
        panel1.add(this.studentIDInput);
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

        this.addStudentBtn = new JButton("Add");
        this.addStudentBtn.addActionListener(new AddStudentListener());
        this.clearInputBtn = new JButton("Clear Form");
        this.clearInputBtn.addActionListener(new ClearFormListener());
        this.processStudentBtn = new JButton("Process");
        this.processStudentBtn.addActionListener(new ProcessStudentListener());
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
        this.studentIDInput.requestFocus();
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
            String surname = this.surnameInput.getText();
            String middlename = this.middlenameInput.getText();
            String firstname = this.firstnameInput.getText();
            String aptNumber = this.aptNumberInput.getText();
            String streetNumber = this.streetNumberInput.getText();
            String streetName = this.streetNameInput.getText();
            String city = this.cityInput.getText();
            String province = this.provinceInput.getText();
            String postalcode = this.postalcodeInput.getText();
            double csl = Double.parseDouble(this.cslInput.getText());
            double osl = Double.parseDouble(this.oslInput.getText());
            Student std = new Student(id, surname, middlename, firstname, aptNumber, streetNumber, streetName, city,
                    province, postalcode, csl, osl);
            this.students.add(std);
            this.messageBoardLabel.setText("Student is successfully added!");
        } catch (Exception exc) {
            this.messageBoardLabel.setText("Something went wrong! Try again!");
        } finally {
            clearInput();
        }
    }

    // ------------------------------------------
    // PRIVATE LISTENER CLASSES
    // ------------------------------------------
    private class ClearFormListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            clearMessageBoard();
            clearInput();
        }
    }

    private class AddStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            clearMessageBoard();
            addStudent();
        }
    }

    private class ProcessStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            new RepaymentCalculationForm(students);
        }
    }
}