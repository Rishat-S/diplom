package ru.netology.netologydiplom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.netologydiplom.dto.FileDTO;
import ru.netology.netologydiplom.facade.FileFacade;
import ru.netology.netologydiplom.payload.response.MessageResponse;
import ru.netology.netologydiplom.service.FileService;
import ru.netology.netologydiplom.validations.ResponseErrorValidation;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cloud")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private FileFacade fileFacade;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @PostMapping("/file")
    public ResponseEntity<MessageResponse> uploadFile(@RequestParam("filename") String fileName, MultipartFile file,
                                                      Principal principal) throws IOException {
        fileService.save(fileName, file, principal);
        return ResponseEntity.ok(new MessageResponse("File uploaded successfully"));
    }

    @DeleteMapping("/file")
    public ResponseEntity<MessageResponse> deleteFile(@RequestParam("filename") String fileName, Principal principal) {
        fileService.deleteFile(fileName, principal);
        return ResponseEntity.ok(new MessageResponse("File deleted successfully"));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FileDTO>> listFiles(@RequestParam("limit") String limit, Principal principal) {
        List<FileDTO> fileList = fileService.getAllFilesByUser(Long.parseLong(limit), principal);
        return ResponseEntity.ok(fileList);
    }

    @PutMapping("/file")
    public ResponseEntity<MessageResponse> updateFile(@RequestParam("filename") String fileName,
                                                      @RequestBody FileDTO fileDTO, Principal principal) {
        fileService.updateFile(fileName, fileDTO.getName(), principal);
        return ResponseEntity.ok(new MessageResponse("File updated successfully"));
    }

    @GetMapping("/file")
    public ResponseEntity<Object> getFile() {
        //TODO:
        return ResponseEntity.ok(new Object()); //FIXME
    }

}
