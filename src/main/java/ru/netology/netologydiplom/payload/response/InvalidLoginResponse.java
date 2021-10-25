package ru.netology.netologydiplom.payload.response;

import lombok.Getter;

@Getter
public class InvalidLoginResponse {

    private final String username;
    private final String password;

    public InvalidLoginResponse() {
        username = "Invalid Username";
        password = "Invalid Password";
    }



}
