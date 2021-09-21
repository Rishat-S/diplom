package ru.netology.netologydiplom.service;

import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;

public interface EntityService {
    CustomersFile getFile(String filename);

    List<CustomersFile> getListFiles();
}
