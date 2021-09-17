package ru.netology.netologydiplom.repository;

import org.springframework.stereotype.Repository;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;

@Repository
public interface CloudRepository {
    CustomersFile getFile(String filename);

    List<CustomersFile> getListFiles(int limit);


}
