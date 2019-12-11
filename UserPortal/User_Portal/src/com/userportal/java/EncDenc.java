package com.userportal.java;

import java.util.Base64;

public class EncDenc {

    public static String encrypt(String pass) {
        String encodedPassword = Base64.getEncoder().encodeToString(pass.getBytes());

        return encodedPassword;
    }

    public static String decrypt(String pass) {
        byte[] decodedByteArray = Base64.getDecoder().decode(pass);
        String decodedPassword = new String(decodedByteArray);
        return decodedPassword;
    }
	
}
