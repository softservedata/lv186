package com.softserve.edu.magento.data.customer.user;

import com.softserve.edu.magento.data.customer.user.Date.Month;

interface IMonth {
	IDay setMonth(Month Month);
}
interface IDay {
	IYear setDay(String day);
}
interface IYear {
	IBuild_Date setYear(String year);
}
interface IBuild_Date {
	IDate build();
}
public class Date implements IMonth,IDay,IYear,IBuild_Date,IDate{
	
	public static enum Month {
		JANUARY("Jan","01"),
		FEBRUARY("Feb","02"),
		MARC("Feb","03"),
		APRIL("Apr","04"),
		MAY("May","05"),
		JUNE("Jun","06"),
		JULY("Jul","07"),
		AUGUST("Aug","08"),
		SEPTEMBER("Sep","09"),
		OCTOBER("Oct","10"),
		NOVEMBER("Nov","11"),
		DECEMBER("Dec","12");
		//
		private String monthName;
		private String monthNumber;

		private Month(String monthName,String monthNumber) {
			this.monthName = monthName;
			this.monthNumber = monthNumber;
		}

		@Override
		public String toString() {
			return this.monthName;
		}
		public String getNumber() {
			return this.monthNumber;
		}
	}
	
	//----------------------------------
	
	private String month;
	private String day;
	private String year;
	private Date() {}
	//setters
	public static IMonth get() {
		return new Date();
	}

	public IDay setMonth(Month Month) {
		this.month = Month.getNumber();
		return this;
	}
	public IYear setDay(String day) {
		this.day = day;
		return this;
	}
	public IBuild_Date setYear(String year) {
		this.year = year;
		return this;
	}
	public IDate build() {
		return this;
	}
	//getters
	public String getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	public String getDateValue() {
		return new String(this.getMonth()+"/"+this.getDay()+"/"+this.getYear());
	}
		
}

