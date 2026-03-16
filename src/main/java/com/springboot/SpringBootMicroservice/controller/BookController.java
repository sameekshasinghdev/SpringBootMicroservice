package com.springboot.SpringBootMicroservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootMicroservice.dto.BookDTO;
import com.springboot.SpringBootMicroservice.entity.Book;
import com.springboot.SpringBootMicroservice.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

//	 @GetMapping("/books")
//	    public String test() {
//	        return "Book Service Working";
//	    }
	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

//	@PostMapping
//	public Book addBook(@RequestBody Book book) {
//		return service.save(book);
//	}
	@PostMapping
	public BookDTO addBook(@Valid @RequestBody BookDTO dto) {
		return service.save(dto);
	}

	@GetMapping
	public List<BookDTO> getBooks() {
		return service.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return service.getBook(id);
	}

	@PutMapping("/{id}")
	public BookDTO updateBook(@Valid @PathVariable Long id, @RequestBody BookDTO book) {
		return service.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Long id) {
		service.deleteBook(id);
		return "Book deleted";
	}

}
