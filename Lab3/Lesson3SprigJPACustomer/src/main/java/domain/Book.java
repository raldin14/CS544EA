package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String ISBN;
    private String author;
    private double price;

    protected Book(){}

    public Book(String title, String ISBN, String author, Double price){
        super();
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    public long getId(){ return id;}
    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', ISBN='%s', author='%s', price='%.2f']", id, title, ISBN, author,price);
    }
}
