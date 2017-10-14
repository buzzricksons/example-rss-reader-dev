package exception;

public class RssNotFoundedException extends RuntimeException {
    public RssNotFoundedException(String message) {
        super(message);
    }
}
