package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.netologydiplom.entity.Customer;

public interface EntityRepository extends JpaRepository<Customer, Long> {
}
