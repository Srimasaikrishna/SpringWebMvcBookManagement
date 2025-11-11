package com.info.service;
import java.util.List;
import java.util.Optional;

import com.info.entity.BookEntity;

public interface BookService {
	
	public List<BookEntity> getAllBooks();
	 void deleteBookById(Integer id);
	 
	 void saveBook(BookEntity book);
	 Optional<BookEntity> getBookById(Integer id);

}
