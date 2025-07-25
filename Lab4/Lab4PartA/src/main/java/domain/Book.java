package domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int isbn;
    private String title;
    private String author;
    @ManyToOne
    @JoinTable(name="book_publisher")
    private Publisher publisher;

    public Book(){}

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
