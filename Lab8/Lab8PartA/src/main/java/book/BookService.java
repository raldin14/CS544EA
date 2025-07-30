package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book){
        if (bookRepository.existsById(book.getIsbn())) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(String isbn){
        bookRepository.deleteById(isbn);
    }

    public Book getBook(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String author){
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
}
