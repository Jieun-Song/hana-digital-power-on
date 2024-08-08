package com.brms.book.service;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookSearchService {

    @Autowired
    private BookDao bookDao;

    public BookSearchService() {
    }

    public Book searchBook(String bNum){
        Book book = bookDao.select(bNum);
        return book;
    }
}
