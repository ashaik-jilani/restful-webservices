/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jilani
 *
 */

@RestController
public class EmployeeController {

	@GetMapping("/filtering")
	public SomeBean doFiltering() {
		return new SomeBean("val1","val2", "val3");
	}
	
}
