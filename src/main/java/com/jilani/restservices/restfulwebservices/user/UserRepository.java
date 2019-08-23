/**
 * 
 */
package com.jilani.restservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jilani
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
