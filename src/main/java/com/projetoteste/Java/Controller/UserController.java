package com.projetoteste.Java.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoteste.Java.Model.User;
import com.projetoteste.Java.Repository.UserRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	 @Autowired UserRepository repository;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> GetAll(){
		List<User> objectUser = repository.findAll();
		if(objectUser.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objectUser);
			
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(value = "id") Long id_User) {
			return repository.findById(id_User)
					.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/")
	public ResponseEntity<User> newUser(@RequestBody User userName) {
		return ResponseEntity.status(201).body(repository.save(userName));
	}

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User updateUser) {
	        return ResponseEntity.status(201).body(updateUser);
}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable (value = "id") long id) {
	repository.deleteById(id);
    }
    }
    
