package ru.netology.netologydiplom.dto;

import lombok.Data;
import ru.netology.netologydiplom.entity.User;

@Data
public class FileDTO {
    private Long id;
    private String name;
    private Long size;
    private byte[] fileBytes;
    private User user;

}
