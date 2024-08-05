package com.example.mvc.service;


import com.example.mvc.dto.BookPojo;
import com.example.mvc.entity.Book;
import com.example.mvc.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepo BookRepo;

    public BookPojo save(BookPojo request) {
        return new BookPojo(BookRepo.saveAndFlush(Book.builder()
                .author(request.getAuthor())
                .name(request.getName())
                .price(request.getPrice())
                .build()));
    }

    public BookPojo update( Integer id,BookPojo request) {
        Book book = BookRepo.getById(id);
        book.setAuthor(request.getAuthor());
        book.setName(request.getName());
        book.setPrice(request.getPrice());
        return new BookPojo(BookRepo.save(book));
    }

    public BookPojo getById(Integer id) {
        return new BookPojo(BookRepo.getById(id));
    }

    public List<BookPojo> getAll() {
        List<BookPojo> list = new ArrayList<>();
        for (Book book : BookRepo.findAll()){
            list.add(new BookPojo(book));
        }
        return list;
    }

    public void delete(Integer id) {
        BookRepo.deleteById(id);
        System.out.println("deleted");
    }

}