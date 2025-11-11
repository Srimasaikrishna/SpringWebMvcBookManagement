package com.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.BookEntity;

public interface BookRepo  extends JpaRepository<BookEntity, Integer>{

}
