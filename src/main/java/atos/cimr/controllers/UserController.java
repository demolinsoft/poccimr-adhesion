package atos.cimr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import atos.cimr.entity.User;
import atos.cimr.repository.UserRepository;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserRepository userRepository;
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User emp) {
		userRepository.save(emp);
		return "User added successfully::"+emp.getId();
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/findUser/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "Deleted User Successfully::"+id;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world !";
	}

}