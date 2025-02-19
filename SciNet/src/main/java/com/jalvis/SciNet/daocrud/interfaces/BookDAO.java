package com.jalvis.SciNet.daocrud.interfaces;

import com.jalvis.SciNet.entities.Book;

import java.util.List;

public interface BookDAO {
    public Book getBookById(Long id);
    public List<Book> getBooks();
    public List<Book> getBooksBySubject(Long id);
    public void addBook(Book book);
    public void updateBook( Book book);
    public void deleteBook(Long id);


}
