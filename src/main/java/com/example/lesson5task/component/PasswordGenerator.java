package com.example.lesson5task.component;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordGenerator {

    public String genRandomPassword(int length){
        final String chars = "lfkasdlfjaslLAKDSJFkdfjaslkdfjasldfkjaslkdfjaslkdfj45646546546ds";
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int i1 = random.nextInt(chars.length());
            StringBuilder append = stringBuilder.append(chars.charAt(i1));
        }
        return stringBuilder.toString();
    }


}
