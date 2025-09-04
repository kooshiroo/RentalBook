package models.book;

import models.book.enums.BookState;
import models.book.enums.Genre;

public class Book {
    private String title;
    private int price;
    private int page;
    private Genre genre;
    private String author;
    private BookState state;

    public Book(String title, int price, int page, Genre genre, String author, BookState state) {
        this.title = title;
        this.price = price;
        this.page = page;
        this.genre = genre;
        this.author = author;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }
    public int getPage() {
        return page;
    }
    public Genre getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public BookState getState() {
        return state;
    }
}
