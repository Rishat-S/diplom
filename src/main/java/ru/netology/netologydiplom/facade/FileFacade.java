package ru.netology.netologydiplom.facade;

import ru.netology.netologydiplom.dto.FileDTO;
import ru.netology.netologydiplom.entity.File;

public class FileFacade {

    public FileDTO fileToFileDTO(File file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setId(file.getId());
        fileDTO.setName(file.getName());
        fileDTO.setSize(file.getSize());
        return fileDTO;
    }
}
