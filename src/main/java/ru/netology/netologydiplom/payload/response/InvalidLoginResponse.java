package ru.netology.netologydiplom.payload.response;

import lombok.Getter;

@Getter
public class InvalidLoginResponse {

    private String username;
    private String password;

    public InvalidLoginResponse() {
        username = "Invalid Username";
        password = "Invalid Password";
    }



}
