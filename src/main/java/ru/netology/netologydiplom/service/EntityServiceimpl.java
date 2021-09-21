package ru.netology.netologydiplom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.entity.CustomersFile;
import ru.netology.netologydiplom.repository.CustomerFileRepository;

import java.util.List;

@Slf4j
@Service
public class EntityServiceimpl implements EntityService {

    CustomerFileRepository customerFileRepository;

    public EntityServiceimpl(CustomerFileRepository customerFileRepository) {
        this.customerFileRepository = customerFileRepository;
    }

    @Override
    public CustomersFile getFile(String filename) {
        return customerFileRepository.findByFileName(filename);
    }

    @Override
    public List<CustomersFile> getListFiles() {
        return customerFileRepository.findAll();
    }
}
