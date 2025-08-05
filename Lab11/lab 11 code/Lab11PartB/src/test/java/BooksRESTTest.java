import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDeleteBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        //cleanup
        given()
                .when()
                .delete("books/878");

        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Book with isbn= 878 is not available"));

    }

    @Test
    public void testPostBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testPutBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        Book updateBook = new Book("878","Book 1234", 18.95, "Joe Smith");

        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(updateBook)
                .when().put("/books/"+updateBook.getIsbn()).then()
                .statusCode(200);

        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 1234"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testGetAllBooksByAuthor() {
        Book book1 = new Book("878","Book 123", 18.95, "Joe Smith");
        Book book2 = new Book("123","Book 000", 10.00, "Raldin Hidalgo");

        // add a book with key 878
        given()
                .contentType("application/json")
                .body(book1)
                .when()
                .post("/books")
                .then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book2)
                .when()
                .post("/books")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/books?author=\"Raldin Hidalgo\"")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("books[0].isbn",equalTo("123"))
                .body("books[0].title",equalTo("Book 000"))
                .body("books[0].price",equalTo(10.00f))
                .body("books[0].author",equalTo("Raldin Hidalgo"));
        // Cleanup
        given().when().delete("/books/878");
        given().when().delete("/books/123");
    }
}
