package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.netologydiplom.entity.Customer;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;

public interface EntityRepository extends JpaRepository<Customer, Long> {
    CustomersFile getFile(String filename);

    List<CustomersFile> getListFiles(int limit);


}
