package currancy.exeption;

public class ConflictDataException extends RuntimeException {
    public ConflictDataException(String message) {
        super(message);
    }
}
