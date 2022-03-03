package ee.taltech.iti0202.files.input;

public class FileReaderException extends RuntimeException {
    /**
     * @param reason
     * @param cause
     */
    public FileReaderException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
