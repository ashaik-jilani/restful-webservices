/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jillU
 *
 */
@Entity
@ApiModel(description = "Model of User")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message="Name should be more than 2 characters")
	private String name;
	
	@Past(message="Date of Birth should not be future date")
	@ApiModelProperty("Date of Birth should not be future Date")
	private Date dob;
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param dob
	 */
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	

}
