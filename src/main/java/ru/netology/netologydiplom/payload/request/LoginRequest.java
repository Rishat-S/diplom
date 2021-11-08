package ru.netology.netologydiplom.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty(message = "Username cannot be empty")
    private String login;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
