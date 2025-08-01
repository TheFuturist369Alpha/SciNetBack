package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.entities.Book;

import java.util.Date;
import java.util.List;


public interface BookService {
    public Book createBook(String name, String description, double price,
                           String image_url, boolean available, Date date_launched, Long subject_id, Long user_id);
    public void addBook(Book book);
    public Book getBookById(Long id);
    public List<Book> getBooks();
    public List<Book> getBooksBySubjectId(Long[] id);
    public List<Book> getBooksByUserId(Long id);
    public void updateBook(Book book);
    public void updateBooks(List<Book> books);
    public void deleteBook(Long id);
}
