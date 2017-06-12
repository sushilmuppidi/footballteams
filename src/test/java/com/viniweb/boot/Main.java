package com.viniweb.boot;

import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
	
		System.out.println(getDate("1999-01-01"));

	}

	
	private static String getDate(String dateStr){
		
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
		
		sdfIn.format(dateStr);
        return dateStr;
	}
}
