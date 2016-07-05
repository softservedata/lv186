package com.softserve.edu.lv186.utils;

public class ColorConverter {
	public static String rgbToHEX(String s1) {
		String[] colorArray;
		colorArray = s1.replace("rgba(", "").split(",");
		String hex = String.format("#%02x%02x%02x", Integer.parseInt(colorArray[0].trim()),
				Integer.parseInt(colorArray[1].trim()), Integer.parseInt(colorArray[2].trim()));
		return hex;
	}
}
