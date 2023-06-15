package com.educandoweb.course.resources;

import java.util.List;
import java.util.Optional;

import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value ="/api")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/users")
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value ="/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> insert(@RequestBody User user){
			user = service.insert(user);
			return ResponseEntity.ok().body(user);
	}

	@DeleteMapping(value = "users/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return  ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);

	}


}
