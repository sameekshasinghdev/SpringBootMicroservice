package com.springboot.SpringBootMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringBootMicroservice.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
