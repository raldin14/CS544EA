package book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    Book findByIsbn(String isbn);
}
