package ru.netology.netologydiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.exceptions.FileNotFoundException;
import ru.netology.netologydiplom.repository.FileRepository;
import ru.netology.netologydiplom.repository.UserRepository;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void tests() {
        User user = userRepository.findUserByUsername("user")
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        this.userExistTest(user);
        this.fileExistTest(user);
    }


    public void userExistTest(User user) {

        Assertions.assertNotNull(user);

    }

    public void fileExistTest(User user) {

        var file = fileRepository.findFileByNameAndUser("name", user)
                .orElseThrow(() -> new FileNotFoundException("File cannot be found"));

        Assertions.assertNotNull(file);

    }

}
