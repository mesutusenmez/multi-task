package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.Profile.ProfileBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Long userId = Long.valueOf("123");

        List<Callable<Profile>> tasks = new ArrayList<Callable<Profile>>();

        tasks.add(new UserService(userId));
        tasks.add(new PhoneService(userId));

        ProfileBuilder profileBuilder = new ProfileBuilder();

        try {
            List<Future<Profile>> profiles = executorService.invokeAll(tasks);

            for (Future<Profile> p : profiles) {
                profileBuilder.user(p.get().getUser()).phoneNumber(p.get().getPhoneNumber()); 
            }

            Profile profile = profileBuilder.build();

            System.out.println(profile.getUser().getId());
            System.out.println(profile.getUser().getName());
            System.out.println(profile.getPhoneNumber());
            long endTime = System.currentTimeMillis();
            System.out.println("App -> Total ms = "+(endTime - startTime));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}