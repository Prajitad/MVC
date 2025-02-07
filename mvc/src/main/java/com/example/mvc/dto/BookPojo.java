package com.example.mvc.dto;



import com.example.mvc.entity.Book;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer id;
    private String name;
    private String author;
    private Double price;

    public BookPojo(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.price = book.getPrice();
    }
}



