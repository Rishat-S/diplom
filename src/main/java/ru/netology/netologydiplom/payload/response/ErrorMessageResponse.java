package ru.netology.netologydiplom.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessageResponse {
    private String message;
    private int id;
}