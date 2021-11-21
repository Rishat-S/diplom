package ru.netology.netologydiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.repository.UserRepository;
import ru.netology.netologydiplom.service.FileService;

import java.security.Principal;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;


    @Test
    @Transactional
    public void tests() {
        User user = userRepository.findUserByUsername("user")
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        this.userExistTest(user);
        this.addFileToCloud();
        this.fileExistTest();
        this.updateFileInTheCloud();
        this.deleteFileFromCloud();
    }


    private void userExistTest(User user) {

        Assertions.assertNotNull(user);

    }

    private void addFileToCloud() {

    }

    private void fileExistTest() {

        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        var file = fileService.getFileByName("name", principal);

        Assertions.assertNotNull(file);

    }

    private void updateFileInTheCloud() {

    }

    private void deleteFileFromCloud() {

    }

}
