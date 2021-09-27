package ru.netology.netologydiplom.service;

import ru.netology.netologydiplom.entity.Customer;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;
import java.util.Optional;

public interface EntityService {
    Optional<CustomersFile> getFile(String filename);

    List<CustomersFile> getListFiles(Customer customer);
}
