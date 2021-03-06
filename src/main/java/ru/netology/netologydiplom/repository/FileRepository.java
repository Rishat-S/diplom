package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.netologydiplom.entity.File;
import ru.netology.netologydiplom.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findAllByUserOrderByCreatedDateDesc(User user);

    Optional<File> findFileByNameAndUser(String name, User user);
}
