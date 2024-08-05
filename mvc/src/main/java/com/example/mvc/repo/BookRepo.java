package com.example.mvc.repo;

import com.example.mvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepo extends
        JpaRepository<Book,Integer> {


}