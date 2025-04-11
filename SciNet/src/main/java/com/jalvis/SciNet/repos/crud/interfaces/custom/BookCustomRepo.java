package com.jalvis.SciNet.repos.crud.interfaces.custom;

import com.jalvis.SciNet.entities.Book;

import java.util.List;

public interface BookCustomRepo {
    public Book getBookById(Long id);
    public List<Book> getBooks();
    public List<Book> getBooksBySubject(Long id);
    public List<Book> getBooksByOwnerId(Long id);
    public void addBook(Book book);
    public void updateBook( Book book);
    public void updateBooks(List<Book> books); 
    public void deleteBook(Long id);


}
