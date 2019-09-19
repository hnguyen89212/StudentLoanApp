package back_end_db;

import java.sql.*;

import student_loan_app.HN_LoanTools;

public class StudentDB {

	private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost:3306/student_loan_app?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
	private static final String username = "root";
	private static final String password = "";

	// Returns true if the ID exists already.
	public static ResultSet checkStudentId(String idInput) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRslt = null;
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			String query = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + idInput;
			myRslt = myStmt.executeQuery(query);
			return myRslt;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public static void addNewStudent(String student_id, String surname, String middlename, String firstname,
			int aptnumber, int streetnumber, String streetname, String city, String province, String postalcode,
			double csl, double osl) {
		Connection myConn = null;
		Statement myStmt = null;
		//
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			// street number is absent
			String query00 = "INSERT INTO STUDENT (STUDENT_ID, SURNAME, MIDDLE_NAME, FIRST_NAME, APT_NUMBER, STREET_NAME, CITY, PROVINCE, POSTAL_CODE, CSL_LOAN_AMOUNT, OSL_LOAN_AMOUNT) "
					+ "VALUES (" + wrapInDoubleQuotes(student_id) + ", " + wrapInDoubleQuotes(surname) + ", "
					+ wrapInDoubleQuotes(middlename) + ", " + wrapInDoubleQuotes(firstname) + ", "
					+ wrapInDoubleQuotes(aptnumber) + ", " + wrapInDoubleQuotes(streetname) + ", "
					+ wrapInDoubleQuotes(city) + ", " + wrapInDoubleQuotes(province) + ", "
					+ wrapInDoubleQuotes(postalcode) + ", " + wrapInDoubleQuotes(csl) + ", " + wrapInDoubleQuotes(osl)
					+ ")";

			// if street number is present
			String query01 = "INSERT INTO STUDENT (STUDENT_ID, SURNAME, MIDDLE_NAME, FIRST_NAME, APT_NUMBER, STREET_NUMBER, STREET_NAME, CITY, PROVINCE, POSTAL_CODE, CSL_LOAN_AMOUNT, OSL_LOAN_AMOUNT) "
					+ "VALUES (" + wrapInDoubleQuotes(student_id) + ", " + wrapInDoubleQuotes(surname) + ", "
					+ wrapInDoubleQuotes(middlename) + ", " + wrapInDoubleQuotes(firstname) + ", "
					+ wrapInDoubleQuotes(aptnumber) + ", " + wrapInDoubleQuotes(streetnumber) + ", "
					+ wrapInDoubleQuotes(streetname) + ", " + wrapInDoubleQuotes(city) + ", "
					+ wrapInDoubleQuotes(province) + ", " + wrapInDoubleQuotes(postalcode) + ", "
					+ wrapInDoubleQuotes(csl) + ", " + wrapInDoubleQuotes(osl) + ")";
			if (streetnumber == 0) {
				myStmt.executeUpdate(query00);
			} else {
				myStmt.executeUpdate(query01);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static boolean updateStudent(String student_id, String surname, String middlename, String firstname,
			int aptnumber, int streetnumber, String streetname, String city, String province, String postalcode,
			double csl, double osl) {
		Connection myConn = null;
		Statement myStmt = null;
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			// before updating, make sure the student_id exists
			// if not => throw error
			String query = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + student_id;
			ResultSet myRslt = myStmt.executeQuery(query);
			int rowCount = 0;
			if (myRslt.last()) {
				rowCount = myRslt.getRow();
				myRslt.beforeFirst();
			}
			if (rowCount == 0) {
				HN_LoanTools.showNoRecordFoundError();
				return false;
			}
			// street number is absent => explicitly set street number to null
			String query00 = "UPDATE STUDENT " + "SET SURNAME = " + wrapInDoubleQuotes(surname) + ", "
					+ "MIDDLE_NAME = " + wrapInDoubleQuotes(middlename) + ", " + "FIRST_NAME = "
					+ wrapInDoubleQuotes(firstname) + ", " + "APT_NUMBER = " + wrapInDoubleQuotes(aptnumber) + ", "
					+ "STREET_NUMBER = NULL, " + "STREET_NAME = " + wrapInDoubleQuotes(streetname) + ", " + "CITY = "
					+ wrapInDoubleQuotes(city) + ", " + "PROVINCE = " + wrapInDoubleQuotes(province) + ", "
					+ "POSTAL_CODE = " + wrapInDoubleQuotes(postalcode) + ", " + "CSL_LOAN_AMOUNT = "
					+ wrapInDoubleQuotes(csl) + ", " + "OSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(osl) + " "
					+ "WHERE STUDENT_ID = " + student_id;

			// if street number is present
			String query01 = "UPDATE STUDENT " + "SET SURNAME = " + wrapInDoubleQuotes(surname) + ", "
					+ "MIDDLE_NAME = " + wrapInDoubleQuotes(middlename) + ", " + "FIRST_NAME = "
					+ wrapInDoubleQuotes(firstname) + ", " + "APT_NUMBER = " + wrapInDoubleQuotes(aptnumber) + ", "
					+ "STREET_NUMBER = " + wrapInDoubleQuotes(streetnumber) + ", " + "STREET_NAME = "
					+ wrapInDoubleQuotes(streetname) + ", " + "CITY = " + wrapInDoubleQuotes(city) + ", "
					+ "PROVINCE = " + wrapInDoubleQuotes(province) + ", " + "POSTAL_CODE = "
					+ wrapInDoubleQuotes(postalcode) + ", " + "CSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(csl) + ", "
					+ "OSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(osl) + " " + "WHERE STUDENT_ID = " + student_id;
			if (streetnumber == 0) {
				System.out.println(query00);
				myStmt.executeUpdate(query00);
			} else {
				myStmt.executeUpdate(query01);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return true;
	}

	private static String wrapInDoubleQuotes(String s) {
		return "\"" + s + "\"";
	}

	private static String wrapInDoubleQuotes(double d) {
		return "\"" + (d + "") + "\"";
	}

	private static String wrapInDoubleQuotes(int i) {
		return "\"" + (i + "") + "\"";
	}

}
