package UEG.FileStorage.controllers.exceptions;

import UEG.FileStorage.exceptions.FileNotFoundInStorageException;
import UEG.FileStorage.exceptions.FileStorageCreationException;
import UEG.FileStorage.exceptions.InvalidFileName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
  @ExceptionHandler(FileStorageCreationException.class)
  public ResponseEntity<String> handleFileStorageCreationException(FileStorageCreationException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }

  @ExceptionHandler(FileNotFoundInStorageException.class)
  public ResponseEntity<String> handleFileNotFoundInStorageException(FileNotFoundInStorageException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }

  @ExceptionHandler(InvalidFileName.class)
  public ResponseEntity<String> handleInvalidFileName(InvalidFileName e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
}
