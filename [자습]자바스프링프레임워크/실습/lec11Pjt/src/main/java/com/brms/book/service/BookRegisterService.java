package com.brms.book.service;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRegisterService {

    @Autowired
    private BookDao bookDao;

    public BookRegisterService() { }

    public void register(Book book) {
        bookDao.insert(book);
    }
}