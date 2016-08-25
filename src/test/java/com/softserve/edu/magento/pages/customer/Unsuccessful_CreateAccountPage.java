package com.softserve.edu.magento.pages.customer;

import com.softserve.edu.magento.pages.customer.components.ErrorSinginCreateAccountComponents;

public class Unsuccessful_CreateAccountPage extends CreateAccountPage{
	public static enum ErrorMessage {
		ALREADY_EXIST_ACCOUNT("There is already an account with this email address."+
	" If you are sure that it is your email address, click here to get your password"+
				" and access your account."),
		PASSWORDS_IS_NOT_THE_SAME("Please enter the same value again."),
		ERROR_PASSWORD_FORMAT("Minimum of different classes of characters"+
		" in password is 3. Classes of characters: Lower Case, Upper Case,"+
				" Digits, Special Characters."),
		ERROR_PASSWORD_FORMAT_MIN_LENGHT("Minimum length of this field must be equal"+
				" or greater than 8 symbols. Leading and trailing spaces will be ignored."),
		ERROR_EMAIL_FORMAT("Please enter a valid email address (Ex: johndoe@domain.com)."),
		FIELD_IS_REQUIRED("This is a required field.");
		//
		private String field;

		private ErrorMessage(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	public static enum ErrorValidatorName {
		FIRSTNAME("firstname"),
		LASTNAME("lastname"),
		EMAIL("email_address"),
		PASSWORD("password"),
		CONFIRMPASSWORD("password-confirmation"),
		;
		//
		private String field;

		private ErrorValidatorName(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	private ErrorSinginCreateAccountComponents errorCreateAccountComponents;
	public Unsuccessful_CreateAccountPage() {
		this.errorCreateAccountComponents = new ErrorSinginCreateAccountComponents();
	}
	public ErrorSinginCreateAccountComponents getErrorCreateAccountComponents() {
		return errorCreateAccountComponents;
	}
	public String getErrorMessageText() {
		return this.getErrorCreateAccountComponents().getErrorMessageText();
	}
	public String getErrorValidatorText(ErrorValidatorName ErrorValidatorName) {
		return this.getErrorCreateAccountComponents().getErrorValidatorText(ErrorValidatorName.toString());
	}
	public boolean isErrorValidator (ErrorValidatorName ErrorValidatorName) {
		System.out.println("isErrorValidator");
		boolean isErrorValidator = false;
		isErrorValidator =  getErrorCreateAccountComponents().isErrorValidator(ErrorValidatorName.toString());
		return isErrorValidator;
	}

	
}
