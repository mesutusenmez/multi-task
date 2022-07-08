package com.example;

import java.util.concurrent.Callable;

public class UserService implements Callable<Profile> {

    User user;

    public UserService(Long userId) {
        user = new User(userId);
    }

    @Override
    public Profile call() throws Exception {
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        user.setName("Kemal");  // Assume that get the name of the user from DB.
        long endTime = System.currentTimeMillis();
        System.out.println("UserService -> Total ms = "+(endTime - startTime));
        return new Profile.ProfileBuilder().user(user).build();
    }

}
