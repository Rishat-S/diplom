package ru.netology.netologydiplom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netologydiplom.entity.UsersFile;
import ru.netology.netologydiplom.service.CloudService;

import java.util.List;

@RestController
@RequestMapping("/cloud")
public class CloudController {

    CloudService cloudService;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    @GetMapping("/file")
    public UsersFile getUsersFile() {
        return cloudService.getUsersFile();
    }

    @GetMapping("/list")
    public List<UsersFile> getListUsersFiles() {
        return cloudService.getListUsersFiles();
    }
}
