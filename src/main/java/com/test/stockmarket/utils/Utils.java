package com.test.stockmarket.utils;

public class Utils {

	public static int convertStringToNumber(String param) {
		int returnNumber = 0;
		if (param == null) {
			returnNumber = 0;
		} else if (param.equals("")) {
			returnNumber = 0;
		} else {
			returnNumber = Integer.parseInt(param);
		}
		return returnNumber;
	}
	
	public static double convertStringToDouble(String param) {
		double returnNumber = 0;
		if (param == null) {
			returnNumber = 0.0;
		} else if (param.equals("")) {
			returnNumber = 0.0;
		} else {
			returnNumber = Double.parseDouble(param);
		}
		return returnNumber;
	}
}
