package ru.netology.netologydiplom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.entity.CustomersFile;
import ru.netology.netologydiplom.repository.EntityRepository;

import java.util.List;

@Slf4j
@Service
public class EntityServiceimpl implements EntityService {

    EntityRepository entityRepository;

    public EntityServiceimpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public CustomersFile getFile(String filename) {
        return entityRepository.getFile(filename);
    }

    @Override
    public List<CustomersFile> getListFiles(int limit) {
        return entityRepository.getListFiles(limit);
    }
}
