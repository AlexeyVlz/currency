package currency.exeption;

public class DataNotFound extends RuntimeException {
    public DataNotFound(String message) {
        super(message);
    }
}
