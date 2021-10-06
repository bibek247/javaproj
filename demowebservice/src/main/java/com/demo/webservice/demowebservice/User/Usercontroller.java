package com.demo.webservice.demowebservice.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Usercontroller {
	
	@Autowired
	private UserDaoService userdaoservice;
	
	// In post method : @RequestBody data will map to the <User> 
	@PostMapping(path="/users-savereturn")
	private ResponseEntity<Object> createuser(@RequestBody User user) {
		// TODO Auto-generated method stub
		
		User newuser = userdaoservice.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newuser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	// In post method : @RequestBody data will map to the <User> 
		@PostMapping(path="/users")
		private void createuser2(@RequestBody User user) {
			// TODO Auto-generated method stub
			User newuser = userdaoservice.save(user);
			
		}
		
	@GetMapping(path="/users")
	public List<User> getalluser() {
		// TODO Auto-generated method stub
		List<User> lu2 = userdaoservice.findall();
		return lu2;
	}
	
	@GetMapping(path="/user/{id}")
	private User getoneuser(@PathVariable int id) {
		// TODO Auto-generated method stub
		User user = userdaoservice.findone(id);
		if(user==null)
			throw new UserNotFoundExpection("id-"+id) {
			};
		return user;
	}


	@GetMapping(path="/users-test")
	public List<User> getalluser3() {
		// TODO Auto-generated method stub
		List<User> lu2 = userdaoservice.findall();
		return lu2;
	}
	
	
	@DeleteMapping(path="/user/{id}")
	private User deleteuser(@PathVariable int id) {
		// TODO Auto-generated method stub
		User user = userdaoservice.deletebyid(id);
		if(user==null)
			throw new UserNotFoundExpection("id-"+id) {
			};
		return user;
	}	
}
