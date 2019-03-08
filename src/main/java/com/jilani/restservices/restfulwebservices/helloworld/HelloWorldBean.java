/**
 * 
 */
package com.jilani.restservices.restfulwebservices.helloworld;

/**
 * @author jillU
 *
 */
public class HelloWorldBean {
	
	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	private String message;

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
