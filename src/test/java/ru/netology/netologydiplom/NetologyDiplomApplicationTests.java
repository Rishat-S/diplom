package ru.netology.netologydiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.repository.UserRepository;
import ru.netology.netologydiplom.service.FileService;

import java.io.*;
import java.security.Principal;

@SpringBootTest
class NetologyDiplomApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;


    @Test
    @Transactional
    public void tests() throws IOException {
        var user = userRepository.findUserByUsername("user")
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        this.userExistTest(user);
        this.addFileToCloud();
        this.getFileByName();
        this.getAllFilesByUser();
        this.updateFileInTheCloud();
        this.deleteFileFromCloud();
    }


    private void userExistTest(User user) {

        Assertions.assertNotNull(user);

    }

    private void addFileToCloud() throws IOException {
        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        File file = new File("src/test/resources/test_files/test.txt");
        InputStream is = new FileInputStream(file);

        MultipartFile multipartFile = new MockMultipartFile("filename", is);

        fileService.save("filename", multipartFile, principal);

    }

    private void getAllFilesByUser() {
        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        var files = fileService.getAllFilesByUser(2L, principal);
    }

    private void getFileByName() {

        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        var file = fileService.getFileByName("filename", principal);

        Assertions.assertNotNull(file);

    }

    private void updateFileInTheCloud() {
        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        fileService.updateFile("filename", "new_filename", principal);
    }

    private void deleteFileFromCloud() {
        Principal principal = Mockito.mock(Principal.class);
        Mockito.when(principal.getName()).thenReturn("user");

        fileService.deleteFile("new_filename", principal);

    }

}
