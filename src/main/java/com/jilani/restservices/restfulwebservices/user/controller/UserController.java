/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jilani.restservices.restfulwebservices.user.User;
import com.jilani.restservices.restfulwebservices.user.dao.UserDaoService;
import com.jilani.restservices.restfulwebservices.user.exception.UserNotFoundException;

/**
 * @author jillU
 *
 */
@RestController
public class UserController {

	@Autowired
	UserDaoService usersDao;
	
	@GetMapping(path="/users")
	public List<User> retriveAllUsers() {
		return usersDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user=usersDao.search(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser=usersDao.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=usersDao.deleteUser(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
	}

	
	
	
}
