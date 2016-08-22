package com.softserve.edu.magento.pages.customer;


import com.softserve.edu.magento.pages.customer.components.ErrorSinginCreateAccountComponents;


public class UnsuccessfulSignInPage extends SignInPage {
	
	public static enum ErrorValidatorNameSingIn {
		EMAIL("email"),
		PASSWORD("pass");
		;
		//
		private String field;

		private ErrorValidatorNameSingIn(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	public static enum ErrorMessageSignIn {
		INVALID_SIGNIN("Invalid login or password."),
		FIELD_IS_REQUIRED("This is a required field."),
		ERROR_EMAIL_FORMATT("Please enter a valid email address (Ex: johndoe@domain.com).");
		//
		private String field;

		private ErrorMessageSignIn(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	private ErrorSinginCreateAccountComponents  errorSinginComponents;
	public UnsuccessfulSignInPage() {
		this.errorSinginComponents = new ErrorSinginCreateAccountComponents();
	}

	public ErrorSinginCreateAccountComponents getErrorSinginComponents() {
		return errorSinginComponents;
	}
	public String getErrorMessageText() {
		return this.getErrorSinginComponents().getErrorMessageText();
	}
	public String getErrorValidatorText(ErrorValidatorNameSingIn ErrorValidatorNameSingIn) {
		return this.getErrorSinginComponents().getErrorValidatorText(ErrorValidatorNameSingIn.toString());
	}
}
