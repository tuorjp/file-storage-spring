package UEG.FileStorage.controllers;

import UEG.FileStorage.controllers.dto.UploadFileResponseDTO;
import UEG.FileStorage.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/files/test")
public class FileUploadTestController {
  @Autowired
  private FileStorageService fileStorageService;

  @PostMapping("/upload")
  public UploadFileResponseDTO uploadFile(@RequestParam("file")MultipartFile file) {
    String fileName = fileStorageService.storeFile(file);

    String fileDownloadUri = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("api/files/test/download")
        .path(fileName)
        .toUriString(); // constrói a uri de download

    UploadFileResponseDTO responseDTO = new UploadFileResponseDTO();
    responseDTO.setFileName(fileName);
    responseDTO.setFileDownloadUri(fileDownloadUri);
    responseDTO.setFileType(file.getContentType());
    responseDTO.setSize(file.getSize());

    return responseDTO;
  }
}
