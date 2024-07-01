package com.demoblaze.models;
import lombok.Getter;

@Getter
public class UserCredential {
    private final String userName;
    private final String password;

    public UserCredential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
