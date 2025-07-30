package book;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message) {
        super("Book with ISBN " + message + " already exists.");
    }
}
