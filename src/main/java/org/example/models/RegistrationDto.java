package org.example.models;

import jdk.jfr.DataAmount;


public class RegistrationDto {
    private String username;
    private String password;

    public RegistrationDto(){
        super();
    }
    public RegistrationDto(String username,String password){
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
