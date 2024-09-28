package com.example.glof_backend.Controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.glof_backend.Model.User;
import com.example.glof_backend.Repository.UserRepository;
import com.example.glof_backend.Service.EmailExistsResponse;
import com.example.glof_backend.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
        User storedUser = userRepository.findByEmail(user.getEmail());
        if (storedUser != null && user.getPassword().equals(storedUser.getPassword())) {
            session.setAttribute("email", storedUser.getEmail());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
	
	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());
        if (storedUser != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
        	userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
	

	   

	    public UserController(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @GetMapping("/check-email/{email}")
	    public ResponseEntity<EmailExistsResponse> checkEmailExists(@PathVariable String email) {
	        boolean exists = userService.existsByEmail(email);
	        EmailExistsResponse emailExistsResponse = new EmailExistsResponse(exists);
	        return ResponseEntity.ok(emailExistsResponse);
	    }

	    
        @PostMapping("/forgotPassword")
	    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
	        String email = request.get("email");
	        String newPassword = request.get("newPassword");
	        
	        User user = userRepository.findByEmail(email);
	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user found with the given email address");
	        }
	        user.setPassword(newPassword);
	        userRepository.save(user);
	        
	        return ResponseEntity.ok("Password reset successful");
	    }
        
        @GetMapping("/profile")
        public ResponseEntity<User> getUserProfile(HttpSession session) {
            String email = (String) session.getAttribute("email");
            if (email == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            User user = userRepository.findByEmail(email);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(user);
        }



}






















//private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//@PostMapping("/register")
//public ResponseEntity<?> registerUser(@RequestBody User user) {
//  if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//      return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
//  }
//  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//  userRepository.save(user);
//  return ResponseEntity.ok("User registered successfully");
//}
//
//@PostMapping("/login")
//public ResponseEntity<?> loginUser(@RequestBody User user) {
//  Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
//  if (!existingUser.isPresent() || !bCryptPasswordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
//      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//  }
//  return ResponseEntity.ok(existingUser.get());
//}