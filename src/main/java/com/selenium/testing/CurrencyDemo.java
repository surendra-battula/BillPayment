package com.selenium.testing;

import java.util.Currency;
import java.util.Locale;

public class CurrencyDemo {
	
	public static void main(String[] args) {
		
	//JPY,AUD,INR,USD
	
	Currency currency = Currency.getInstance("GBP");
	System.out.println(currency.getDisplayName());
	//System.out.println(currency.getCurrencyCode());	
		
	}

}
