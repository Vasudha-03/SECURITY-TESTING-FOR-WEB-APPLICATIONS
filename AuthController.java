package org.jsp.springBoot.Controller;

import org.jsp.springBoot.Dto.ResponseStructure;
import org.jsp.springBoot.Entity.User;
import org.jsp.springBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User savedUser = userRepository.save(user);

		ResponseStructure<User> response = new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("User registered successfully");
		response.setData(savedUser);

		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}