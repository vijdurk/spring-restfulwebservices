package com.rest.restfulservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDaoService u;
	
	public UserResource(UserDaoService u) {
		this.u=u;
	}
	@GetMapping("/users")
	public List<User> retriveAll(){
		return u.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
User user = u.findUser(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		return user;
	}
	//test post from talentapi tester by sending a post request
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = u.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		u.deleteById(id);
	}
}
