package com.springboot.SpringBootMicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.SpringBootMicroservice.dto.BookDTO;
import com.springboot.SpringBootMicroservice.entity.Book;
import com.springboot.SpringBootMicroservice.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository repository;

	private BookDTO convertToDTO(Book book) {
		return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
	}

	private Book convertToEntity(BookDTO dto) {
		Book book = new Book();
		book.setId(dto.getId());
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		return book;
	}

	public BookService(BookRepository repository) {
		this.repository = repository;
	}

	public BookDTO save(BookDTO dto) {

		// return repository.save(book);
		Book book = convertToEntity(dto);
		Book savedBook = repository.save(book);
		return convertToDTO(savedBook);
	}

	public List<BookDTO> getAllBooks() {
		return repository.findAll().stream().map(this::convertToDTO).toList();
	}

	public Book getBook(Long id) {
		return repository.findById(id).orElse(null);
	}

	public BookDTO updateBook(Long id, BookDTO dto) {
		Book existingBook = repository.findById(id).orElse(null);

		if (existingBook != null) {
			existingBook.setTitle(dto.getTitle());
			existingBook.setAuthor(dto.getAuthor());
			existingBook.setPrice(dto.getPrice());

			Book updated = repository.save(existingBook);
			return convertToDTO(updated);
		}

		return null;
	}

	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
}
