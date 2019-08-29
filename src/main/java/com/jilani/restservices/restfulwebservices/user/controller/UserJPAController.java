/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.jilani.restservices.restfulwebservices.user.Post;
import com.jilani.restservices.restfulwebservices.user.PostRepository;
import com.jilani.restservices.restfulwebservices.user.User;
import com.jilani.restservices.restfulwebservices.user.UserRepository;
import com.jilani.restservices.restfulwebservices.user.exception.UserNotFoundException;

/**
 * @author jillU
 *
 */
@RestController
public class UserJPAController {

	@Autowired
	UserRepository userReposiotry;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping(path="/jpa/users")
	public List<User> retriveAllUsers() {
		return userReposiotry.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public Resource<User>  retrieveUser(@PathVariable int id) {
		Optional<User> user=userReposiotry.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		Resource<User> resource=new Resource<User>(user.get());
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser=userReposiotry.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userReposiotry.deleteById(id);
	
	}
	
	
	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post>  retrieveAllPosts(@PathVariable int id) {
		Optional<User> user=userReposiotry.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		return user.get().getPosts();
	}
	
	
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Object>  createUserPosts(@PathVariable int id, @RequestBody Post post) {
		Optional<User> user=userReposiotry.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id- "+id);
		}
		post.setUser(user.get());
		postRepository.save(post);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
	
}
