package com.selenium.lc.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selenium.lc.Property_editer.CreditCardFormatterEditer;
import com.selenium.lc.Property_editer.Property_Curency_editer;
import com.selenium.lc.formatter.CreditCardFormatter;
import com.selenium.test.api.BillDTO;
import com.selenium.test.api.CreditCard;

@Controller
public class TestController {

	@RequestMapping("/")
	public String showHomepage(@ModelAttribute("billDTO") BillDTO billDTO) {
		
		CreditCard  creditCard = new CreditCard();
		
		creditCard.setFirstFourDigits(1111);
		creditCard.setSecondFourDigits(2222);
		creditCard.setThirdFourDigits(3333);
		creditCard.setLastFourDigits(4444);
		
		billDTO.setCreditCard(creditCard);

		return "bill-page";
	}

	@RequestMapping(value = "/process-bill")
	public String showResultPage(@Valid @ModelAttribute("billDTO") BillDTO billDTO, BindingResult result) {

		if (result.hasErrors()) {

			return "bill-page";
		}

		return "result-page";

	}

	@InitBinder
	public void initbinder(WebDataBinder binder) {

		// custom date editor
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateformat, true);
		binder.registerCustomEditor(Date.class, "date", customDateEditor);

		// custom number editor

		NumberFormat numberFormat = new DecimalFormat("##,###.00");

		CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class, numberFormat, true);

		binder.registerCustomEditor(BigDecimal.class, "amount", customNumberEditor);

		// number format

		NumberFormat numberFormat1 = new DecimalFormat("## ###.00");

		CustomNumberEditor customNumberEditor1 = new CustomNumberEditor(BigDecimal.class, numberFormat, true);

		binder.registerCustomEditor(BigDecimal.class, "amount", customNumberEditor1);

		// currency editor

		Property_Curency_editer Curency_editer = new Property_Curency_editer();

		binder.registerCustomEditor(Currency.class, "currency", Curency_editer);

		
		
		// if we are commentting the override add format method then we can customformater in init method
		//binder.addCustomFormatter(new CreditCardFormatter());

		
		
		
		
		
		
		// if we are using propertyeditformatter instead of formater
		//CreditCardFormatterEditer creditCardFormatterEditer = new CreditCardFormatterEditer();
		//binder.registerCustomEditor(CreditCard.class,"creditCard", creditCardFormatterEditer);
		
		
		
		
		
		
	}

}
