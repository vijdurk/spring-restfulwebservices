package com.rest.restfulservices.simple;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class stringController {

	private MessageSource m;
	public stringController(MessageSource m) {
		this.m=m;
	}
	//@RequestMapping("/printastring")
	@GetMapping("/printastring")
	public String print() {
		return "Prints a string";
	}
	@GetMapping("/printastring/{name}")
	public String print(@PathVariable String name) {
		return "Prints a string"+name;
	}
	@GetMapping(path = "/printastring-internationalized")
	public String printInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return m.getMessage("good.morning.message", null, "Default Message", locale );
		
		//return "Hello World V2"; 
		
		//1:
		//2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

	}

}
