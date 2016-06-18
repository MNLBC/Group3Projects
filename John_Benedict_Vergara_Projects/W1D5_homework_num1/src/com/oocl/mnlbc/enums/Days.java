package com.oocl.mnlbc.enums;

public enum Days {

	SUNDAY("No appointment for today!"),
	MONDAY("Meet the Boss."),
	TUESDAY("Party Day!"),
	WEDNESDAY("Conference at home!"),
	THURSDAY("Call your friends!"),
	FRIDAY("GO home Early!"),
	SATURDAY("Just have a Rest!! ");
	
	private String value;
	
	Days(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
