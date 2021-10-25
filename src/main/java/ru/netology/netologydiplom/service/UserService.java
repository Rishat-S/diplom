package ru.netology.netologydiplom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.dto.UserDTO;
import ru.netology.netologydiplom.entity.ERole;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.exceptions.UserExistException;
import ru.netology.netologydiplom.payload.request.SignupRequest;
import ru.netology.netologydiplom.repository.UserRepository;

import java.security.Principal;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(SignupRequest userIn) {
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setFirstName(userIn.getFirstname());
        user.setLastName(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist. Please check credentials");
        }

    }

    public User updateUser(UserDTO userDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());

        return userRepository.save(user);
    }

    public User getCurrentUser(Principal principal) {
        return getUserByPrincipal(principal);
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));
    }

}
