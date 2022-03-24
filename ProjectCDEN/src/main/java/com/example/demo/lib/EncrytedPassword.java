package com.example.demo.lib;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPassword {

	// Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
    public static boolean checkPass(String password, String encodedPassword) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	return encoder.matches(password, encodedPassword);
    			
    }
}
