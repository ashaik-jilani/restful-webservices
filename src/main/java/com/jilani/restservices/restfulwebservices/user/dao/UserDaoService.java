/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jilani.restservices.restfulwebservices.user.User;

/**
 * @author jillU
 *
 */
@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<>();
	private static int count=3;
	
	static {
		users.add(new User(1, "Alam",new Date()));
		users.add(new User(2, "Noor",new Date()));
		users.add(new User(3, "Jilani",new Date()));
	}
	
	public List<User>findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	
	public User search(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
	return null;
	}
	
	public User deleteUser(int id) {
		Iterator<User> iterator =users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
	return null;
	}

}
