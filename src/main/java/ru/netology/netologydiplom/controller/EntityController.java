package ru.netology.netologydiplom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netologydiplom.entity.CustomersFile;
import ru.netology.netologydiplom.service.EntityService;

import java.util.List;

@RestController
@RequestMapping("/cloud")
public class EntityController {

    EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping("/file")
    public CustomersFile getFile(@RequestParam(name = "filename") String filename) {
        return entityService.getFile(filename);
    }

    @GetMapping("/list")
    public List<CustomersFile> getListFiles(@RequestParam(name = "limit") int limit) {
        return entityService.getListFiles();
    }
}
