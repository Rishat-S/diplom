package ru.netology.netologydiplom.facade;

import org.springframework.stereotype.Component;
import ru.netology.netologydiplom.dto.FileDTO;
import ru.netology.netologydiplom.entity.File;

@Component
public class FileFacade {

    public FileDTO fileToFileDTO(File file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFilename(file.getName());
        fileDTO.setSize(file.getSize());
        return fileDTO;
    }
}
