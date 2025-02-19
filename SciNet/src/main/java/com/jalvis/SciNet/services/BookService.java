package com.jalvis.SciNet.services;

import com.jalvis.SciNet.entities.Book;

import java.util.Date;
import java.util.List;


public interface BookService {
    public Book createBook(String name, String description, double price,
                           String image_url, boolean available, Date date_launched, Long subject_id);
    public void addBook(Book book);
    public Book getBookById(Long id);
    public List<Book> getBooks();
    public List<Book> getBooksBySubjectId(Long id);
    public void updateBook(Book book);
    public void deleteBook(Long id);
}
