package ru.netology.netologydiplom.service;

import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.entity.UsersFile;
import ru.netology.netologydiplom.repository.CloudRepository;

import java.util.List;

@Service
public class CloudService {

    CloudRepository cloudRepository;

    public CloudService(CloudRepository cloudRepository) {
        this.cloudRepository = cloudRepository;
    }

    public UsersFile getUsersFile(String filename) {
        return cloudRepository.getUsersFile(filename);
    }

    public List<UsersFile> getListUsersFiles(int limit) {
        return cloudRepository.getListUsersFiles(limit);
    }
}
