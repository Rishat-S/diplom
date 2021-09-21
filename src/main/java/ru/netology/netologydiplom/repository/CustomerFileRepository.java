package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.netologydiplom.entity.Customer;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;
import java.util.Optional;

public interface CustomerFileRepository extends JpaRepository<CustomersFile, Long> {

    CustomersFile findByFileName(String fileName);

    List<CustomersFile> findAll();
}
