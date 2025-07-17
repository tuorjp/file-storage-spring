package UEG.FileStorage.exceptions;

public class FileNotFoundInStorageException extends RuntimeException {
  public FileNotFoundInStorageException(String message) {
    super(message);
  }
}
