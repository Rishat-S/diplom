package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.netologydiplom.entity.CustomersFile;

public interface CustomerFileRepository extends JpaRepository<CustomersFile, Long> {
}
