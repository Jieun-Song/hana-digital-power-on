package com.brms.book.dao;

import com.brms.book.Book;

import java.util.HashMap;
import java.util.Map;

public class BookDao {
    private Map<String, Book> bookDB =
            new HashMap<String, Book>();
    public void insert(Book book){
        bookDB.put(book.getBNum(),book);
    }
    public Book select(String bNum){
        return bookDB.get(bNum);
    }
    public void update(Book book){}
    public void delete(){}
    public Map<String, Book> getBookDB(){
        return bookDB;
    }
}
