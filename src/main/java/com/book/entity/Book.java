package com.book.entity;

import com.book.dto.BookDTO;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public @Data class Book {
    @Id
    @GeneratedValue
    private Integer bookId;
    private String bookName;
    private String author;
    private String coverImage;
    private Integer price;
    private Integer quantity;

    public Book() {

    }

    public Book(BookDTO bookDTO){
        this.author = bookDTO.getAuthor();
        this.coverImage = bookDTO.getCoverImage();
        this.price = bookDTO.getPrice();
        this.quantity = bookDTO.getQuantity();
        this.bookName = bookDTO.getBookName();
    }

    public Book(Integer bookId, BookDTO bookDTO){
        this.bookId = bookId;
        this.bookName = bookDTO.getBookName();
        this.author = bookDTO.getAuthor();
        this.coverImage = bookDTO.getCoverImage();
        this.quantity = bookDTO.getQuantity();
        this.price = bookDTO.getPrice();
    }
}