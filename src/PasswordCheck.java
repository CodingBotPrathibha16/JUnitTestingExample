import java.util.Scanner;

public class PasswordCheck {

	// Declare the maximum number of letters in a password
	public static final int PASSWORD_LENGTH = 8;

	// main method to check the other password is accepted or not
	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("1. A password must have at least eight characters long.\n"
				+ "2. A password must contain at least one number and one special character \n"
				+ "3. A password must be ASCII characters. \n"
				+ "Input the new password (Following Criteria should meet... \n");
		String s = input.nextLine();

		if (isAcceptablePassword(s)) {
			System.out.println("Password updated sucessfully with valid details above");
		} else {
			System.out.println(
					"Not a valid password,kindly check for characters; number, special character, no white space,"
							+ "atleast one uppercase and one lowercase \n" + "Please Login Again");
		}

	}

	/**
	 * This method will verify the old password is not same as newPassword
	 * 
	 * @param {String} newPassword is the new password from test data.
	 * @param {String} oldPassword from the test data
	 * 
	 * @return {boolean} indicating pass or fail status of function execution.
	 * 
	 */

	public boolean validatePasswordMismatch(String newPassword, String oldPassword) {
		return (newPassword != null && oldPassword != null && !newPassword.equals(oldPassword));
	}

	/**
	 * This method will verify the password confirmation comparing newPassword .
	 * 
	 * @param {String} newPassword is the new password from test data.
	 * @param {String} confirmPassword is the confirmation of password from the test
	 *        data.
	 * 
	 * @returns {boolean} indicating pass or fail status of function execution.
	 * 
	 */

	public boolean validatePasswordIsSame(String newPassword, String confirmPassword) {
		return (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword));
	}

	/**
	 * This method will verify the user name is not same as newPassword
	 * 
	 * @param {String} userName from test data.
	 * @param {String} newPassword from the test data
	 * 
	 * @return {boolean} indicating pass or fail status of function execution.
	 * 
	 */

	public boolean validateUserNameNotSame(String userName, String newPassword) {
		return (userName != null && newPassword != null && newPassword.indexOf(userName) > -1);

	}

	/**
	 * This method will verify the Empty field.
	 * 
	 * @param {String} oldPassword from test data.
	 * @param {String} newPassword from the test data
	 * @param {String} confirmPassword from the test data
	 * 
	 * 
	 * @return {boolean} indicating pass or fail status of function execution.
	 * 
	 */

	public boolean validatePasswordEmptyField(String oldPassword, String newPassword, String confirmPassword) {
		// if password field is empty
		// it will display error message "Field can not be empty"
		if (oldPassword.isEmpty() && oldPassword.length() < 1) {
			System.out.println("Field can not be empty");
			return false;
		} else if (newPassword.isEmpty() && newPassword.length() < 1) {
			System.out.println("Field can not be empty");
			return false;
		} else if (confirmPassword.isEmpty() && confirmPassword.length() < 1) {
			System.out.println("Field can not be empty");
			return false;
		}
		return true;

	}

	/**
	 * This method will verify the Strong Password.
	 * 
	 * @param {String} newPassword from test data.
	 * 
	 * @return {boolean} indicating pass or fail status of function execution.
	 * 
	 */

	public boolean validateStrongPasswordCheck(String newPassword) {
		int upChars = 0, lowChars = 0;
		int special = 0, digits = 0;
		char ch;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the Password: ");
		String password = s.nextLine();
		int total = password.length();
		if (total < PASSWORD_LENGTH) {
			System.out.println("\nThe Password is invalid!");
			return false;
		}
		if (password.trim().isEmpty()) {
			System.out.println("Password should not contain white space.");
			return false;
		}

		else {
			for (int i = 0; i < total; i++) {
				ch = password.charAt(i);
				if (Character.isUpperCase(ch))
					upChars = 1;
				else if (Character.isLowerCase(ch))
					lowChars = 1;
				else if (Character.isDigit(ch))
					digits = 1;
				else
					special = 1;
			}
		}
		if (upChars == 1 && lowChars == 1 && digits == 1 && special == 1)
			System.out.println("\nThe Password is Strong.");

		else
			System.out.println("\nThe Password is Weak.");
		return false;

	}

	/**
	 * This method will verify the password is accepted or not.
	 * 
	 * @param {String} newPassword from test data.
	 * @returns {boolean} indicating true or false status of function execution.
	 *          considering the password length, at least a digit and a special
	 *          characters, and only contains printable ASCII
	 */

	public static boolean isAcceptablePassword(String newPassword) {

		if (!passwordContainEnoughCharacters(newPassword)) {
			return false;
		}

		if (!passwordContainADigit(newPassword)) {
			return false;
		}

		if (!passwordContainASpecialCharacter(newPassword)) {
			return false;
		}

		if (!passwordContainOnlyPrintableASCII(newPassword)) {
			return false;
		}

		if (!noWhiteSpaceForPassword(newPassword)) {
			return false;
		}

		if (!passwordWithOneUpperCase(newPassword)) {
			return false;
		}

		if (!passwordWithOneLowerCase(newPassword)) {
			return false;
		}
		return true;
	}

	/**
	 * This method will verify the enough character check.
	 * 
	 * @param {String} newPassword from the test data
	 * @return {boolean} return pass or fail if password contains greater than or
	 *         equal to PASSWORD_LENGTH characters
	 */
	public static boolean passwordContainEnoughCharacters(String newPassword) {
		return (newPassword.length() >= PASSWORD_LENGTH);
	}

	/**
	 * This method will verify the Special character check.
	 * 
	 * @param {String} newPassword from the test data
	 * @return {boolean} true if the password contains one of the accepted special
	 *         characters
	 */

	public static boolean passwordContainASpecialCharacter(String newPassword) {
		String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
		if (!newPassword.matches(specialChars)) {
			System.out.println("Password should contain atleast one special character");
			return false;
		}
		return true;
	}

	/**
	 * This method will verify the digit. numeric value in it.
	 * 
	 * @param {String} newPassword from the test data
	 * @return {boolean} true if the password contains a digit 0-9
	 */
	public static boolean passwordContainADigit(String newPassword) {

		String numbers = "(.*[0-9].*)";
		if (!newPassword.matches(numbers)) {
			System.out.println("Password should contain atleast one number.");
			return false;
		}
		return true;
	}

	/**
	 * This method will verify the printable ASCII.
	 * 
	 * @param {String} newPassword from the test data
	 * @return {boolean} true if the password contains printable ASCII
	 * 
	 */
	public static boolean passwordContainOnlyPrintableASCII(String newPassword) {

		int firstPrintableASCII = 32;
		int lastPrintableASCII = 126;

		for (int i = 0; i < newPassword.length(); i++) {
			char aChar = newPassword.charAt(i);

			if (aChar < firstPrintableASCII || aChar > lastPrintableASCII) {
				System.out.println("Password should have only printable ASCII");
				return false;
			}
		}
		return true;
	}

	/**
	 * This method will verify no white space in password.
	 * 
	 * @param {String} whiteSpace from the test data
	 * @return {boolean} false if the password contains white space in it
	 * 
	 */
	public static boolean noWhiteSpaceForPassword(String whiteSpace) {
		for (int i = 0; i < whiteSpace.length(); i++) {
			if (whiteSpace.contains(" ")) {
				System.out.println("Password should not contain white space.");
				return false;
			}

		}
		return true;
	}

	/**
	 * This method will verify the upperCase check.
	 * 
	 * @param {String} upperCase from the test data
	 * @return {boolean} true if the password contains upper case in it
	 * 
	 */
	public static boolean passwordWithOneUpperCase(String upperCase) {
		String upperCaseChars = "(.*[A-Z].*)";
		if (!upperCase.matches(upperCaseChars)) {
			System.out.println("Password should contain atleast one upper case alphabet");
			return false;
		}
		return true;
	}

	/**
	 * This method will verify the lowerCase check.
	 * 
	 * @param {String} lowerCase from the test data
	 * @return {boolean} true if the password contains lower case in it
	 * 
	 */

	public static boolean passwordWithOneLowerCase(String lowerCase) {
		String lowerCaseChars = "(.*[a-z].*)";
		if (!lowerCase.matches(lowerCaseChars)) {
			System.out.println("Password should contain atleast one lower case alphabet");
			return false;
		}
		return true;
	}

}