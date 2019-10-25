package semester02_Project2_StudentLoanGUIApp;

/**
 * DOCUMENTATION
 * 
 * Author       : Hai Nguyen
 * Student ID   : 0904995
 * Professor    : Madhavi Mohan
 * Class        : INFO 3134 S2019
 * Project      : Student Loan GUI App
 * Program      : Student.java
 * Description  : A class to simulate a student.
 * Dependencies : none
 */

public class Student {

    // ------------------------------------------
    // INSTANCE VARIABLES
    // ------------------------------------------
    private String studentID; // "0087901"
    private String surname;
    private String middlename;
    private String firstName;
    private String aptNumber;
    private String streetNumber;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;
    private double cslLoanAmount;
    private double oslLoanAmount;

    // ------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------
    public Student(String studentID, String surname, String middlename, String firstName, String aptNumber,
            String streetNumber, String streetName, String city, String province, String postalCode,
            double cslLoanAmount, double oslLoanAmount) {
        this.studentID = "" + studentID;
        this.setSurname("" + surname);
        this.setMiddlename("" + middlename);
        this.setFirstName("" + firstName);
        this.setAptNumber("" + aptNumber);
        this.setStreetNumber("" + streetNumber);
        this.setStreetName("" + streetName);
        this.setCity("" + city);
        this.setProvince("" + province);
        this.setPostalCode("" + postalCode);
        this.setCslLoanAmount(cslLoanAmount);
        this.setOslLoanAmount(oslLoanAmount);
    }

    /**
     * Returns a string representation for a student.
     */
    @Override
    public String toString() {
        return "Student Name: " + this.surname + ", " + this.firstName + " " + this.middlename + "\n"
                + "Student Number: " + this.studentID + "\n" + "CSL Amount is $" + this.cslLoanAmount + "\n"
                + "OSL Amount is $" + this.oslLoanAmount;
    }

    // ------------------------------------------
    // SETTERS AND GETTERS
    // ------------------------------------------
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public double getCslLoanAmount() {
        return cslLoanAmount;
    }

    public void setCslLoanAmount(double cslLoanAmount) {
        this.cslLoanAmount = cslLoanAmount;
    }

    public double getOslLoanAmount() {
        return oslLoanAmount;
    }

    public void setOslLoanAmount(double oslLoanAmount) {
        this.oslLoanAmount = oslLoanAmount;
    }

    public String getStudentID() {
        return studentID;
    }

}
