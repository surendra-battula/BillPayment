package com.selenium.lc.Property_editer;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class Property_Curency_editer extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		Currency currency = Currency.getInstance( text.toUpperCase());
		
		setValue(currency);
	}
	
	

}
