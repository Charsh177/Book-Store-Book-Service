package com.book.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

public @Data class BookDTO {

    @NotNull(message = "book name can't be null")
    private String bookName;

    @NotNull(message = "author name can't be null")
    private String author;

    @NotNull(message = "book image cant be null")
    private String coverImage;

    @NotNull(message = "price cant be empty")
    private Integer price;

    @NotNull(message = "Quantity cant be empty")
    private Integer quantity;

}