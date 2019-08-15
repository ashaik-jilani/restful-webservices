/**
 * 
 */
package com.jilani.restservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jillU
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello I am from HelloWorld Bean");
	}
	
	@GetMapping(path="hello-world/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World!, %s", name));
	}
	
	
	@GetMapping(path="/hello-i18n")
	public String helloWorldI18n(@RequestHeader(name="Accept-Language",required = false) Locale locale) {
		return  messageSource.getMessage("good.morning.message", null, locale);
	}
	
	

}
