package ru.netology.netologydiplom.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtTokenSuccessResponse {
    private boolean success;
    @JsonProperty("auth-token")
    private String token;
}
