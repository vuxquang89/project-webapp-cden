package com.example.demo.lib;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libraries {

	/*convert string to date*/ 
	public static LocalDate convertStringToDate(String dateString) {
		//System.out.println(dateString);
		String[] str = dateString.split("-");
		String d = str[0];
		String m = str[1];
		String y = str[2];
		
		return LocalDate.parse(y+"-"+m+"-"+d);
	}
	
	/* get date now*/
	public static String getDateNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
	
	/* get date now*/
	public static String getDateTimeNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
	
	/* convert date to string*/
	public static String convertDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		return formatter.format(date);
	}
	
	/*ma hoa pass sang MD5*/
	public static String hashMD5(String input) {
		MessageDigest md;
		try {
			// Static getInstance method is called with hashing MD5
            md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	// Method to generate a random alphanumeric password of a specific length
    public static String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
    
    /*tính ngày kết thúc chiến dịch*/
    public static long simpleDate(String endDay) {
    	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    	LocalDate today =  LocalDate.now();     //Today    	
    	LocalDate endD = LocalDate.parse(endDay, DateTimeFormatter.ISO_LOCAL_DATE);    	
    	Duration diff = Duration.between(today.atStartOfDay(), endD.atStartOfDay());
    	
    	return diff.toDays();
    }
    
    /*random number integer from min to max*/
    public static int random(int min, int max) {
    	int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
    	return random_int;
    }
    
    /*random password*/
    public static String randomPassword(int len) {
    	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	SecureRandom rnd = new SecureRandom();

    	
    	StringBuilder sb = new StringBuilder(len);
    	for(int i = 0; i < len; i++)
    	   sb.append(AB.charAt(rnd.nextInt(AB.length())));
    	return sb.toString();
    	
    }
    
    /*get the first letter to string*/
    public static String getFirstChar(String str) {
    	String nameString = "";
    	char[] charArray = str.toCharArray();
        boolean foundSpace = true;
        //sử dụng vòng lặp for để duyệt các phần tử trong charArray
        for(int i = 0; i < charArray.length; i++) {
        	// nếu phần tử trong mảng là một chữ cái
        	if(Character.isLetter(charArray[i])) {
        		// kiểm tra khoảng trắng có trước chữ cái
        		if(foundSpace) {
        			//đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
        			nameString += Character.toUpperCase(charArray[i]);
        			foundSpace = false;
        		}
        	}
        	else {
        		foundSpace = true;
        	}
        }
        return nameString;
    }
    
    /*convert phone to hidden*/
    public static String hiddenPhone(String phone) {
    	char[] charArray = phone.toCharArray();
        for (int i = 0; i < charArray.length - 3; i++) {
			charArray[i] = 42;
		}
        return String.valueOf(charArray);
    }
    
    /*kiem tra nhap so đt*/
	public static boolean isValidPhone(String s)
    {
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
 
        Matcher m = p.matcher(s);
 
        // Returning boolean value
        return (m.matches());
    }
	
	/*kiem tra nhap so*/
	public static boolean isValidNumber(String s)
    {
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d$");
 
        Matcher m = p.matcher(s);
 
        // Returning boolean value
        return (m.matches());
    }
	
	/*kiem tra email hop le*/
	/*
	public static boolean isEmail(String email) {
		String regexPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\\\[[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\\\-0-9]+\\\\.)+[a-zA-Z]{2,}))$";
		// Creating a Pattern class object
        Pattern p = Pattern.compile(regexPattern);
 
        Matcher m = p.matcher(email);
 
        // Returning boolean value
        return (m.matches());
	}
	*/
	/*kiem tra ky tu dac biet*/
	public static boolean isSpecial(String s){
		// Creating a Pattern class object
        Pattern p = Pattern.compile("^[a-zA-Z0-9-_]*$");
        Matcher m = p.matcher(s);
        
        // Returning boolean value
        return (m.matches());
	}
}
