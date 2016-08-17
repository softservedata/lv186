package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.Date.Month;
import com.softserve.edu.magento.data.customer.user.PersonalInfo_User.Gender;
import com.softserve.edu.magento.data.customer.user.SigninInfo_User.Group;

public class CustomerUserRepository {

	private static volatile CustomerUserRepository instance = null;

	private CustomerUserRepository() {
	}

	public static CustomerUserRepository get() {
		if (instance == null) {
			synchronized (CustomerUserRepository.class) {
				if (instance == null) {
					instance = new CustomerUserRepository();
				}
			}
		}
		return instance;
	}

	public ICustomerUser UserYaryna() {
		return CustomerUser.get()
				.setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Yaryna")
						.setLastname("Kharko")
						.setSignUpNewsletter(true)
						.build()
						.setGender(Gender.FEMALE)
						.setBirthdayDate(Date.get()
								.setMonth(Month.MAY)
								.setDay("26")
								.setYear("1997")
								.build())
				)
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("ya.kharko@nltu.lviv.ua")
						.setPassword("25263004Ya")
						.setConfirmPassword("25263004Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build()
				.setContactInfo_User(ContactInfo_User.get()
						.setPhoneNumber("0987656786")
						.setStreetAddress("st. petra pancha 10")
						.setCity("Lviv")
						.setState("Lviv")
						.setPostalCode("70020")
						.setCountry("Ukraine")
						.build()
						.setCompanyName("SoftServe")
						.setFax("")
						.setVatNumber("10009876543")
				);
	}

	public ICustomerUser invalidUser() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("ggg")
						.setLastname("GGG")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("ggg@mail.com")
						.setPassword("77777777")
						.setConfirmPassword("77777777")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser newUser() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("yulia")
						.setLastname("koval")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("yulia.koval@mail.com")
						.setPassword("11111111yU")
						.setConfirmPassword("11111111yU")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	//USERS SPECIAL SYMB

	public ICustomerUser User_Special_Symb1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname(";")
						.setLastname(";")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail(";")
						.setPassword(";123456T")
						.setConfirmPassword(";123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_Special_Symb1_1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname(";")
						.setLastname(";")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail(";@gmail.com")
						.setPassword(";123456T")
						.setConfirmPassword(";123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_Special_Symb2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname(":")
						.setLastname(":")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail(":")
						.setPassword(":123456T")
						.setConfirmPassword(":123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb3() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("/")
						.setLastname("/")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("/")
						.setPassword("/123456T")
						.setConfirmPassword("/123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb4() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("|")
						.setLastname("|")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("|")
						.setPassword("|123456T")
						.setConfirmPassword("|123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb5() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("[")
						.setLastname("[")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("[")
						.setPassword("[123456T")
						.setConfirmPassword("[123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb6() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("{")
						.setLastname("{")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("{")
						.setPassword("{123456T")
						.setConfirmPassword("{123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb7() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("*")
						.setLastname("*")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("*")
						.setPassword("*123456T")
						.setConfirmPassword("*123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb8() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("!")
						.setLastname("!")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("!")
						.setPassword("!123456T")
						.setConfirmPassword("!123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb9() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("(")
						.setLastname("(")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("(")
						.setPassword("(123456T")
						.setConfirmPassword("(123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb10() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname(")")
						.setLastname(")")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail(")")
						.setPassword(")123456T")
						.setConfirmPassword(")123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb11() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("=")
						.setLastname("=")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("=")
						.setPassword("=123456T")
						.setConfirmPassword("=123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb12() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("#")
						.setLastname("#")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("#")
						.setPassword("#123456T")
						.setConfirmPassword("#123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb13() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("_")
						.setLastname("_")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("_")
						.setPassword("_123456T")
						.setConfirmPassword("_123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb14() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("%")
						.setLastname("%")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("%")
						.setPassword("%123456T")
						.setConfirmPassword("%123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb15() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("^")
						.setLastname("^")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("^")
						.setPassword("^123456T")
						.setConfirmPassword("^123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Special_Symb16() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("?")
						.setLastname("?")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("?")
						.setPassword("?123456T")
						.setConfirmPassword("?123456T")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	// CYRYLIC SYMB

	public ICustomerUser User_Cyrylic_Symb1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Андрій")
						.setLastname("Андрієнко")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("андрій")
						.setPassword("Aндрій1234")
						.setConfirmPassword("Aндрій1234")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Cyrylic_Symb2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Андрій")
						.setLastname("Андрієнко")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("андрій@gmail.com")
						.setPassword("Aндрій1234")
						.setConfirmPassword("Aндрій1234")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	// LATIN SYMBL

	public ICustomerUser User_Latin_Symb1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew")
						.setPassword("Andrew1234")
						.setConfirmPassword("Andrew1234")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Latin_Symb2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("Andrew1234")
						.setConfirmPassword("Andrew1234")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}



	// DIGIT SYMB

	public ICustomerUser User_Digit_Symb1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("12345")
						.setLastname("12345")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("12345")
						.setPassword("12345678Ya")
						.setConfirmPassword("12345678Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_Digit_Symb2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("12345")
						.setLastname("12345")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("12345@gmail.com")
						.setPassword("12345678Ya")
						.setConfirmPassword("12345678Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	// PASSWORD FIELD EP + BV :

	public ICustomerUser User_BV1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("1")
						.setConfirmPassword("1")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_BV2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("")
						.setConfirmPassword("")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}


	public ICustomerUser User_BV3() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("123Ta67")
						.setConfirmPassword("123Ta67")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

	public ICustomerUser User_BV4() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("12Ya5678")
						.setConfirmPassword("12Ya5678")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}


	// DESICION TABLE FOR PASSWORD FIELD
	public ICustomerUser User_DT_PASSWORD1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("12Ya56789")
						.setConfirmPassword("12Ya56789")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("andrewan")
						.setConfirmPassword("andrewan")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD3() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("ANDRIENKO")
						.setConfirmPassword("ANDRIENKO")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD4() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("12Y456789")
						.setConfirmPassword("12Y456789")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD5() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("12y456789")
						.setConfirmPassword("12y456789")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD6() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("Andrienko")
						.setConfirmPassword("Andrienko")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD7() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("^&*()%$>")
						.setConfirmPassword("^&*()%$>")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD8() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("^&yard%$>")
						.setConfirmPassword("^&yard%$>")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD9() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("^&Yard12>")
						.setConfirmPassword("^&Yard12>")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT_PASSWORD10() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Andrew")
						.setLastname("Andrienko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("andrew@gmail.com")
						.setPassword("^&YARD12>")
						.setConfirmPassword("^&YARD12>")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	// functional desicion table
	public ICustomerUser User_DT1() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorenko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("olyaFedorenko@gmail.com")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("olyaFedorenko123")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT2() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorenko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("olyaFedorenko@gmail.com")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("olyaFedorenko")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT3() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorenko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("olyaFedorenko")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("olyaFedorenko123")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT4() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorenko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("olyaFedorenko")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("olyaFedorenko")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT5() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("")
						.setLastname("")
						.setSignUpNewsletter(false)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("")
						.setPassword("")
						.setConfirmPassword("")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT6() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("olyaFedorenko@gmail.com")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT7() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorenko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("")
						.setPassword("olyaFedorenko123")
						.setConfirmPassword("olyaFedorenko123")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT8() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Yaryna")
						.setLastname("Kharko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("ya.kharko@nltu.lviv.ua")
						.setPassword("25263004Ya")
						.setConfirmPassword("25263004Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT9() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Yaryna")
						.setLastname("Kharko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("kharko@gmail.com")
						.setPassword("12345678Ya")
						.setConfirmPassword("12345678Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT10() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Kharko")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("kharko@gmail.com")
						.setPassword("12345678Ya")
						.setConfirmPassword("12345678Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT11() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorova")
						.setSignUpNewsletter(true)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("kharko@gmail.com")
						.setPassword("12345678911Ya")
						.setConfirmPassword("12345678911Ya")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}
	public ICustomerUser User_DT12() {
		return CustomerUser.get().
				setPersonalInfo(PersonalInfo_User.get()
						.setFirstname("Olya")
						.setLastname("Fedorova")
						.setSignUpNewsletter(false)
						.build())
				.setSigninInfo(SigninInfo_User.get()
						.setEmail("OlyaFedorova@gmail.com")
						.setPassword("OlyaFedorova123")
						.setConfirmPassword("OlyaFedorova123")
						.setAssosiateToWebsite("Main Website")
						.setGroup(Group.GENERAL)
						.build())
				.build();
	}

}

//    public List<IUser> getExistUsersCVS() {
//        return new UserUtils().getAllUsers();
//    }

//    public List<IUser> getExistUsersExcel() {
//        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
//    }


