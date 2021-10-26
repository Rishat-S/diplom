package ru.netology.netologydiplom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.netologydiplom.dto.FileDTO;
import ru.netology.netologydiplom.entity.File;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.repository.FileRepository;
import ru.netology.netologydiplom.repository.UserRepository;

import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.List;

@Service
public class FileService {
    public static final Logger LOG = LoggerFactory.getLogger(FileService.class);
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    public FileService(FileRepository fileRepository, UserRepository userRepository) {
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
    }

    public File save(FileDTO fileDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        File file = new File();
        file.setUser(user);
        file.setName(fileDTO.getName());
        file.setFileBytes(fileDTO.getFileBytes());
        file.setSize(fileDTO.getSize());

        LOG.info("Saving file for user: {}", user.getEmail());
        return fileRepository.save(file);
    }

    public List<File> getAllFilesByUser(Principal principal) {
        User user = getUserByPrincipal(principal);
        return fileRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public File getFileById(Long fileId, Principal principal) throws FileNotFoundException {
        User user = getUserByPrincipal(principal);
        return fileRepository.findFileByIdAndUser(fileId, user)
                .orElseThrow(() -> new FileNotFoundException("File cannot be found for username: " + user.getUsername()));
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));
    }
}
