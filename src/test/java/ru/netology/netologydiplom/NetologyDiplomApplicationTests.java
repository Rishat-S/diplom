package ru.netology.netologydiplom;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.exceptions.FileNotFoundException;
import ru.netology.netologydiplom.repository.FileRepository;
import ru.netology.netologydiplom.repository.UserRepository;
import ru.netology.netologydiplom.service.FileService;

import java.security.Principal;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() {
        Principal mockPrincipal = Mockito.mock(Principal.class);
        Mockito.when(mockPrincipal.getName()).thenReturn("user");

        User user = userRepository.findUserByUsername(mockPrincipal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        var file = fileRepository.findFileByNameAndUser("name", user)
                .orElseThrow(() -> new FileNotFoundException("File cannot be found"));

        Assertions.assertNotNull(file);

    }


}
