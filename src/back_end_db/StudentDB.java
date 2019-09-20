package back_end_db;

import java.sql.*;

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
 * Program : StudentDB.java<br>
 * <p>
 * Description : An interface to interact with MySQL database<br>
 * <p>
 * Dependencies : none<br>
 */

public class StudentDB {

	private static final String DB_CONNECTION_STRING = "jdbc:mysql://localhost:3306/student_loan_app?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
	private static final String username = "root";
	private static final String password = "";

	/**
	 * Gets all Student instances from DB.
	 * 
	 * @return an ResultSet object representing all Student records.
	 * @throws SQLException
	 */
	public static ResultSet getAll() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRslt = null;
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			String query = "SELECT * FROM STUDENT";
			myRslt = myStmt.executeQuery(query);
			return myRslt;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return myRslt;
	}

	/**
	 * Gets a specific Student given an ID
	 * 
	 * @param idInput
	 * @return a ResultSet representing a Student record
	 * @throws SQLException
	 */
	public static ResultSet checkStudentId(String idInput) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRslt = null;
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			String query = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + idInput;
			myRslt = myStmt.executeQuery(query);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return myRslt;
	}

	/**
	 * Adds a new Student instance into DB.
	 * 
	 * @param student_id
	 * @param surname
	 * @param middlename
	 * @param firstname
	 * @param aptnumber
	 * @param streetnumber
	 * @param streetname
	 * @param city
	 * @param province
	 * @param postalcode
	 * @param csl
	 * @param osl
	 * @throws SQLException
	 */
	public static void addNewStudent(String student_id, String surname, String middlename, String firstname,
			int aptnumber, int streetnumber, String streetname, String city, String province, String postalcode,
			double csl, double osl) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		//
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			if (streetnumber == 0) {
				String query00 = "INSERT INTO STUDENT (STUDENT_ID, SURNAME, MIDDLE_NAME, FIRST_NAME, APT_NUMBER, STREET_NAME, CITY, PROVINCE, POSTAL_CODE, CSL_LOAN_AMOUNT, OSL_LOAN_AMOUNT) "
						+ "VALUES (" + wrapInDoubleQuotes(student_id) + ", " + wrapInDoubleQuotes(surname) + ", "
						+ wrapInDoubleQuotes(middlename) + ", " + wrapInDoubleQuotes(firstname) + ", "
						+ wrapInDoubleQuotes(aptnumber) + ", " + wrapInDoubleQuotes(streetname) + ", "
						+ wrapInDoubleQuotes(city) + ", " + wrapInDoubleQuotes(province) + ", "
						+ wrapInDoubleQuotes(postalcode) + ", " + wrapInDoubleQuotes(csl) + ", "
						+ wrapInDoubleQuotes(osl) + ")";
				myStmt.executeUpdate(query00);
			} else {
				String query01 = "INSERT INTO STUDENT (STUDENT_ID, SURNAME, MIDDLE_NAME, FIRST_NAME, APT_NUMBER, STREET_NUMBER, STREET_NAME, CITY, PROVINCE, POSTAL_CODE, CSL_LOAN_AMOUNT, OSL_LOAN_AMOUNT) "
						+ "VALUES (" + wrapInDoubleQuotes(student_id) + ", " + wrapInDoubleQuotes(surname) + ", "
						+ wrapInDoubleQuotes(middlename) + ", " + wrapInDoubleQuotes(firstname) + ", "
						+ wrapInDoubleQuotes(aptnumber) + ", " + wrapInDoubleQuotes(streetnumber) + ", "
						+ wrapInDoubleQuotes(streetname) + ", " + wrapInDoubleQuotes(city) + ", "
						+ wrapInDoubleQuotes(province) + ", " + wrapInDoubleQuotes(postalcode) + ", "
						+ wrapInDoubleQuotes(csl) + ", " + wrapInDoubleQuotes(osl) + ")";
				myStmt.executeUpdate(query01);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Given a specific student by his ID, updates his information.
	 * 
	 * @param student_id
	 * @param surname
	 * @param middlename
	 * @param firstname
	 * @param aptnumber
	 * @param streetnumber
	 * @param streetname
	 * @param city
	 * @param province
	 * @param postalcode
	 * @param csl
	 * @param osl
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateStudent(String student_id, String surname, String middlename, String firstname,
			int aptnumber, int streetnumber, String streetname, String city, String province, String postalcode,
			double csl, double osl) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			// before updating, make sure the student_id exists
			// if not => throw error => return false;
			String query = "SELECT * FROM STUDENT WHERE STUDENT_ID = " + student_id;
			ResultSet myRslt = myStmt.executeQuery(query);
			int rowCount = 0;
			if (myRslt.last()) {
				rowCount = myRslt.getRow();
				myRslt.beforeFirst();
			}
			if (rowCount == 0) {
				myConn.close();
				myStmt.close();
				return false;
			}
			if (streetnumber == 0) {
				String query00 = "UPDATE STUDENT " + "SET SURNAME = " + wrapInDoubleQuotes(surname) + ", "
						+ "MIDDLE_NAME = " + wrapInDoubleQuotes(middlename) + ", " + "FIRST_NAME = "
						+ wrapInDoubleQuotes(firstname) + ", " + "APT_NUMBER = " + wrapInDoubleQuotes(aptnumber) + ", "
						+ "STREET_NUMBER = NULL, " + "STREET_NAME = " + wrapInDoubleQuotes(streetname) + ", "
						+ "CITY = " + wrapInDoubleQuotes(city) + ", " + "PROVINCE = " + wrapInDoubleQuotes(province)
						+ ", " + "POSTAL_CODE = " + wrapInDoubleQuotes(postalcode) + ", " + "CSL_LOAN_AMOUNT = "
						+ wrapInDoubleQuotes(csl) + ", " + "OSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(osl) + " "
						+ "WHERE STUDENT_ID = " + student_id;
				myStmt.executeUpdate(query00);
			} else {
				String query01 = "UPDATE STUDENT " + "SET SURNAME = " + wrapInDoubleQuotes(surname) + ", "
						+ "MIDDLE_NAME = " + wrapInDoubleQuotes(middlename) + ", " + "FIRST_NAME = "
						+ wrapInDoubleQuotes(firstname) + ", " + "APT_NUMBER = " + wrapInDoubleQuotes(aptnumber) + ", "
						+ "STREET_NUMBER = " + wrapInDoubleQuotes(streetnumber) + ", " + "STREET_NAME = "
						+ wrapInDoubleQuotes(streetname) + ", " + "CITY = " + wrapInDoubleQuotes(city) + ", "
						+ "PROVINCE = " + wrapInDoubleQuotes(province) + ", " + "POSTAL_CODE = "
						+ wrapInDoubleQuotes(postalcode) + ", " + "CSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(csl) + ", "
						+ "OSL_LOAN_AMOUNT = " + wrapInDoubleQuotes(osl) + " " + "WHERE STUDENT_ID = " + student_id;
				myStmt.executeUpdate(query01);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Deletes a Student (maybe null) record from DB given his ID. Note: Even the
	 * parameter student_id does not match any Student record, there is no
	 * error/warning/exception throw.
	 * 
	 * @param student_id
	 */
	public static void deleteStudent(String student_id) {
		Connection myConn = null;
		Statement myStmt = null;
		String query = "DELETE FROM STUDENT WHERE STUDENT_ID = " + student_id + ";";
		try {
			myConn = DriverManager.getConnection(DB_CONNECTION_STRING, username, password);
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Wraps parameter inside double quotes.
	 * 
	 * @param s
	 * @return
	 */
	private static String wrapInDoubleQuotes(String s) {
		return "\"" + s + "\"";
	}

	/**
	 * Wraps parameter inside double quotes.
	 * 
	 * @param d
	 * @return
	 */
	private static String wrapInDoubleQuotes(double d) {
		return "\"" + (d + "") + "\"";
	}

	/**
	 * Wraps parameter inside double quotes.
	 * 
	 * @param i
	 * @return
	 */
	private static String wrapInDoubleQuotes(int i) {
		return "\"" + (i + "") + "\"";
	}

}
