package com.example.glof_backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.glof_backend.Repository.UserRepository;

@Service
public class UserService {
	   @Autowired
	    private UserRepository userRepository;

	    public boolean existsByEmail(String email) {
	        return userRepository.existsByEmail(email);
	    }


}


