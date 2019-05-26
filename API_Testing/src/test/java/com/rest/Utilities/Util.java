package com.rest.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {

	public static String EmployeName() {
		String name = "Purna"+RandomStringUtils.randomAlphabetic(2);
		return name;
	}
	
	public static String EmployeSalary() {
		String name = RandomStringUtils.randomNumeric(5);
		return name;
	}
	public static String EmployeAge() {
		String name = "2"+RandomStringUtils.randomNumeric(1);
		return name;
	}

	
	
	
}
