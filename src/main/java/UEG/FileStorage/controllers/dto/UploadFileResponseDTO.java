package UEG.FileStorage.controllers.dto;

import lombok.Data;

@Data
public class UploadFileResponseDTO {
  private String fileName;
  private String fileDownloadUri;
  private String fileType;
  private long size;
}
