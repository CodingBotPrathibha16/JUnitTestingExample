
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckTest {

	@Test
	public void validatePasswordMismatch_Testdata() throws Exception {
		PasswordCheck validator = new PasswordCheck();
		String newPassword = null;
		String confirmPassword = null;
		assertFalse(validator.validatePasswordMismatch(newPassword, confirmPassword));

		newPassword = "Password@123";
		assertFalse(validator.validatePasswordMismatch(newPassword, confirmPassword));

		confirmPassword = "Password@123";
		assertFalse(validator.validatePasswordMismatch(newPassword, confirmPassword));

		newPassword = "ABCD1234@";
		confirmPassword = "Password@123";
		assertTrue(validator.validatePasswordMismatch(newPassword, confirmPassword));
	}

	@Test
	public void validatePasswordIsSame_Testdata() throws Exception {
		PasswordCheck validator = new PasswordCheck();
		String newPassword = null;
		String oldPassword = null;
		assertFalse(validator.validatePasswordIsSame(newPassword, oldPassword));

		newPassword = "Password@123";
		assertFalse(validator.validatePasswordIsSame(newPassword, oldPassword));

		oldPassword = "Password@122";
		assertFalse(validator.validatePasswordIsSame(newPassword, oldPassword));

	}

	@Test
	public void validateUserNameNotSame_Testdata() throws Exception {
		PasswordCheck validator = new PasswordCheck();
		String newPassword = null;
		String userName = null;
		assertFalse(validator.validateUserNameNotSame(userName, newPassword));

		userName = "videoMonitoring";
		assertFalse(validator.validateUserNameNotSame(userName, newPassword));

		newPassword = "Java@2022";
		assertFalse(validator.validateUserNameNotSame(userName, newPassword));

	}

	// Strong password check
	@Test
	public void validateStrongPasswordCheck_TestData() {
		PasswordCheck validator = new PasswordCheck();
		String newPassword = null;
		assertFalse(validator.validateStrongPasswordCheck(newPassword));
	}

	// Empty Field Validation
	@Test
	public void validatePasswordEmptyField_TestData() {
		PasswordCheck validator = new PasswordCheck();
		String newPassword = null;
		String oldPassword = null;
		String confirmPassword = null;

		oldPassword = "";
		assertFalse(validator.validatePasswordEmptyField(oldPassword, newPassword, confirmPassword));

		newPassword = "";
		assertFalse(validator.validatePasswordEmptyField(oldPassword, newPassword, confirmPassword));

		confirmPassword = "";
		assertFalse(validator.validatePasswordEmptyField(oldPassword, newPassword, confirmPassword));

	}

}
