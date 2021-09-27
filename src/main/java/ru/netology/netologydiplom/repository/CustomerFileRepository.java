package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.netologydiplom.entity.Customer;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerFileRepository extends JpaRepository<CustomersFile, Long> {

    Optional<CustomersFile> findCustomersFileByFileName(String fileName);

    List<CustomersFile> findAllByCustomer(Customer customer);
}
