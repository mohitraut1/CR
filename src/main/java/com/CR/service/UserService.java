package com.CR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CR.model.User;
import com.CR.repository.UserRepository;

import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class UserService {


	    @Autowired
	    private UserRepository userRepository;

	    public void signUp(User user) throws ValidationException {
	        // Perform validation
	        validateUser(user);

	        // Check if username already exists
	        if (userRepository.findByUsername(user.getUsername()) != null) {
	            throw new ValidationException("Username already exists");
	        }

	        // Save user
	        userRepository.save(user);
	    }

	    public User login(String username, String password) throws ValidationException {
	        // Perform validation
	        validateLoginInput(username, password);

	        User user = userRepository.findByUsername(username);

	        // Check if user exists and password matches
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        } else {
	            throw new ValidationException("Invalid username or password");
	        }
	    }

	    public void updateProfile(User user) throws ValidationException {
	        // Perform validation
	        validateUser(user);

	        // Check if user exists
	        User existingUser = userRepository.findByUsername(user.getUsername());
	        if (existingUser == null) {
	            throw new ValidationException("User not found");
	        }

	        // Update user profile
	        userRepository.update(user);
	    }

	    private void validateUser(User user) throws ValidationException {
	        // Validate username
	        if (!user.getUsername().matches("^[a-zA-Z0-9]{4,15}$")) {
	            throw new ValidationException("Username must be 4 to 15 characters long and contain only letters and digits");
	        }

	        // Validate password
	        if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])[A-Za-z\\d@#$%^&+=]{8,15}$")) {
	            throw new ValidationException("Password must be 8 to 15 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
	        }

	        // Perform other validations as needed (e.g., email format)
	    }

	    private void validateLoginInput(String username, String password) throws ValidationException {
	        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	            throw new ValidationException("Username and password are required");
	        }
	    }
	}