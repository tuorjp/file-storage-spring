package UEG.FileStorage.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
//indica qual o prefixo no arquivo file.properties, no caso é o file.
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
  private String uploadDir; //é o upload-dir em application.properties
}
