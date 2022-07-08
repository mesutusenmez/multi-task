package com.example;

import java.util.concurrent.Callable;

/**
 * Assume a callable service that get the phone number of the user from DB.
 * 
 */
public class PhoneService implements Callable<Profile> {

    Long userId;

    public PhoneService(Long userId) {
        this.userId = userId;
    }

    @Override
    public Profile call() throws Exception {    
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long phoneNumber =  Long.valueOf("9021230001010"); // Assume that get the phone number of the user from DB.
        long endTime = System.currentTimeMillis();
        System.out.println("PhoneService -> Total ms = "+(endTime - startTime));
        return new Profile.ProfileBuilder().phoneNumber(phoneNumber).build();
    }

    
}
