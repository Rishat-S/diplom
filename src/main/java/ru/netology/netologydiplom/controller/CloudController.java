package ru.netology.netologydiplom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netologydiplom.entity.UsersFile;

import java.util.List;

@RestController
@RequestMapping("/cloud")
public class CloudController {

    @GetMapping("/file")
    public UsersFile getUsersFile() {
        return null; //FIXME:
    }

    @GetMapping("/list")
    public List<UsersFile> getListUsersFiles() {
        return null; //FIXME:
    }
}
