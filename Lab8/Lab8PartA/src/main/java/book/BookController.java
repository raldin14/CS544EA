package book;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?>  getAllBooks(){
        try{
            List<Book> books = bookService.getAllBooks();
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(params = "isbn")
    public ResponseEntity<?> getBook(@RequestParam("isbn") String isbn){
        Book book = bookService.getBook(isbn);
        return book != null ? new ResponseEntity<Book>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn){
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<?>  searchBooks(@PathVariable("author") String author){
        return new ResponseEntity<List<Book>>(bookService.searchBooks(author), HttpStatus.OK) ;
    }
}
