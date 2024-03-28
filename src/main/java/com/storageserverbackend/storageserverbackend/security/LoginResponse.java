package com.storageserverbackend.storageserverbackend.security;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {

    @Setter
    @Getter
    private String token;


    @Setter
    @Getter
    private long expiresIn;

    public LoginResponse(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public LoginResponse() {
    }

}