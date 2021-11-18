package ru.netology.netologydiplom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.netology.netologydiplom.service.FileService;
import ru.netology.netologydiplom.service.UserService;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest() {
    }


}
