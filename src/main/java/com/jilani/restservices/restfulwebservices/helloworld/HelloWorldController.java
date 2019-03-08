/**
 * 
 */
package com.jilani.restservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jillU
 *
 */
@RestController
public class HelloWorldController {
	
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
		return new HelloWorldBean(String.format("Hello Wolrd!, %s", name));
	}
	
	

}