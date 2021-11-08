package ru.netology.netologydiplom.facade;

import ru.netology.netologydiplom.dto.UserDTO;
import ru.netology.netologydiplom.entity.User;

public class UserFacade {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstName());
        userDTO.setLastname(user.getLastName());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

}
