package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.netologydiplom.entity.CustomersFile;

import java.util.List;

@Repository
public interface CustomerFileRepository extends JpaRepository<CustomersFile, Long> {

    CustomersFile findByFileName(String fileName);

    List<CustomersFile> findAll(); // FIXME:
}
