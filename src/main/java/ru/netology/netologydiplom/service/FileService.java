package ru.netology.netologydiplom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.netologydiplom.dto.FileDTO;
import ru.netology.netologydiplom.entity.File;
import ru.netology.netologydiplom.entity.User;
import ru.netology.netologydiplom.exceptions.FileNotFoundException;
import ru.netology.netologydiplom.facade.FileFacade;
import ru.netology.netologydiplom.repository.FileRepository;
import ru.netology.netologydiplom.repository.UserRepository;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    public static final Logger LOG = LoggerFactory.getLogger(FileService.class);
    private final FileRepository fileRepository;
    private final UserRepository userRepository;
    private final FileFacade fileFacade;

    public FileService(FileRepository fileRepository, UserRepository userRepository, FileFacade fileFacade) {
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
        this.fileFacade = fileFacade;
    }

    public void save(String filename, MultipartFile multipartFile, Principal principal) throws IOException {
        User user = getUserByPrincipal(principal);
        File file = new File();
        file.setUser(user);
        file.setName(filename);
        file.setFileBytes(multipartFile.getBytes());
        file.setSize(multipartFile.getSize());

        LOG.info("Saving file for user: {}", user.getEmail());
        fileRepository.save(file);
    }

    public List<FileDTO> getAllFilesByUser(Long limit, Principal principal) {
        User user = getUserByPrincipal(principal);
        List<File> fileList = fileRepository.findAllByUserOrderByCreatedDateDesc(user);
        return fileList.stream()
                .limit(limit)
                .map(fileFacade::fileToFileDTO)
                .collect(Collectors.toList());
    }

    public File getFileByName(String fileName, Principal principal) throws FileNotFoundException {
        User user = getUserByPrincipal(principal);
        return fileRepository.findFileByNameAndUser(fileName, user)
                .orElseThrow(() -> new FileNotFoundException("File cannot be found for username: " + user.getUsername()));
    }

    public void deleteFile(String fileName, Principal principal) {
        File file = getFileByName(fileName, principal);
        fileRepository.delete(file);
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));
    }

    public void updateFile(String fileName, String newFileName, Principal principal) {
        File file = getFileByName(fileName, principal);
        file.setName(newFileName);
        fileRepository.save(file);
    }
}
