package com.selenium.lc.converter;

import org.springframework.core.convert.converter.Converter;

import com.selenium.test.api.CreditCard;

public class CreditcardConverter implements Converter<String, CreditCard> {

	@Override
	public CreditCard convert(String source) {
		
		//splitting the credit card
		String[] digitsArray = source.split("-");
		
		//Setting credit card values
		CreditCard creditCard = new CreditCard();
		
		creditCard.setFirstFourDigits(Integer.valueOf(digitsArray[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(digitsArray[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(digitsArray[2]));
		creditCard.setLastFourDigits(Integer.valueOf(digitsArray[3]));
		
		
		//returning credit card objects
		return creditCard;
	}
	
	
	
	

}
