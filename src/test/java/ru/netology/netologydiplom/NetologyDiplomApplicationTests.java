package ru.netology.netologydiplom;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.netology.netologydiplom.service.FileService;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private FileService fileService;

    @Test
    public void createUserTest() {
    }


}
