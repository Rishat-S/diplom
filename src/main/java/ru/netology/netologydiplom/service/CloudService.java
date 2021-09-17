package ru.netology.netologydiplom.service;

import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.entity.CustomersFile;
import ru.netology.netologydiplom.repository.CloudRepository;

import java.util.List;

@Service
public class CloudService {

    CloudRepository cloudRepository;

    public CloudService(CloudRepository cloudRepository) {
        this.cloudRepository = cloudRepository;
    }

    public CustomersFile getFile(String filename) {
        return cloudRepository.getFile(filename);
    }

    public List<CustomersFile> getListFiles(int limit) {
        return cloudRepository.getListFiles(limit);
    }
}
