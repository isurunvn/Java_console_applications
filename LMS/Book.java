import java.util.ArrayList;

public class Book {
    private String isbn;
    private String book_name;
    private String author;

    public Book(String isbn, String book_name, String author){
        this.isbn = isbn;
        this.book_name = book_name;
        this.author = author;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return book_name;
    }

    public String getAuthor(){
        return author;
    }

}
