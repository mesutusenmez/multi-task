package com.example;

public class Profile {
    private final User user;
    private final Long phoneNumber;
    
    private Profile(ProfileBuilder builder) {
        this.user = builder.user;
        this.phoneNumber = builder.phoneNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }
 
    public User getUser() {
        return user;
    }

    public static class ProfileBuilder {

        private User user;
        private Long phoneNumber;

        public ProfileBuilder user(User user) {
            if(user != null) {
                this.user = user;
            }
            return this;
        }

        public ProfileBuilder phoneNumber(Long phoneNumber) {
            if(phoneNumber != null) {
                this.phoneNumber = phoneNumber;
            }
            return this;
        }

        public Profile build() {
            Profile profile = new Profile(this);
            return profile;
        }

    }
    
}
