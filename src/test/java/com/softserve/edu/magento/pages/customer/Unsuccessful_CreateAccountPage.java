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

	
}
