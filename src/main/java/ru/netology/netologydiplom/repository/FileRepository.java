package ru.netology.netologydiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.netologydiplom.entity.File;
import ru.netology.netologydiplom.entity.User;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findAllByUser(User user);

    Optional<File> findFileByIdAndUser(Long id, User user);
}
