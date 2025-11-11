package com.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.info.entity.BookEntity;
import com.info.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookrepo;

    public BookServiceImpl(BookRepo bookrepo) {
        this.bookrepo = bookrepo;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookrepo.findAll();
    }

    @Override
    public void deleteBookById(Integer id) {
        bookrepo.deleteById(id);
    }

    @Override
    public void saveBook(BookEntity book) {
        bookrepo.save(book);
    }

    @Override
    public Optional<BookEntity> getBookById(Integer id) {
        return bookrepo.findById(id);
    }
}
