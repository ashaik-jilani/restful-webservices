/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user.exception;

import java.util.Date;

/**
 * @author jillU
 *
 */
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String detail;
	/**
	 * @param timestamp
	 * @param message
	 * @param detail
	 */
	public ExceptionResponse(Date timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	

}
