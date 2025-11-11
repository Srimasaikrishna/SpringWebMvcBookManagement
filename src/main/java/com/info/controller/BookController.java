package com.info.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.entity.BookEntity;
import com.info.service.BookServiceImpl;

@Controller
public class BookController {

	private final BookServiceImpl bookService;

	public BookController(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	// ✅ Display all books
	@GetMapping("/books")
	public ModelAndView getBooks() {
		List<BookEntity> allBooks = bookService.getAllBooks();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("list", allBooks);
		return mav;
	}


	@GetMapping("/addbook")
	public ModelAndView showAddBookForm() {
		ModelAndView mav = new ModelAndView("save");
		mav.addObject("book", new BookEntity());
		return mav;
	}


	@PostMapping("/post")
	public ModelAndView saveBook(@ModelAttribute("book") BookEntity book) {
		bookService.saveBook(book);
		return new ModelAndView("redirect:/books");
	}


	@GetMapping("/delete/{id}")
	public ModelAndView deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return new ModelAndView("redirect:/books");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editBook(@PathVariable Integer id) {
		Optional<BookEntity> bookOpt = bookService.getBookById(id);
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("book", bookOpt.orElse(new BookEntity()));
		return mav;
	}

	
	@PostMapping("/update")
	public ModelAndView updateBook(@ModelAttribute("book") BookEntity book) {
		bookService.saveBook(book); // save() will update if ID already exists
		return new ModelAndView("redirect:/books");
	}
}
