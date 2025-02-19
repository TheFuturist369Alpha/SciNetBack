package com.jalvis.SciNet.services;

import com.jalvis.SciNet.daocrud.interfaces.BookDAO;
import com.jalvis.SciNet.daocrud.interfaces.SubjectDAO;
import com.jalvis.SciNet.entities.Book;
import com.jalvis.SciNet.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    private final SubjectDAO subdao;
    private final BookDAO bookdao;

    @Autowired
    public BookServiceImpl(SubjectDAO subdao, BookDAO bookdao){this.subdao=subdao; this.bookdao=bookdao;}

    @Override
    public  Book createBook( String name, String description, double price,
                             String image_url, boolean available, Date date_launched, Long subject_id) {

        Subject sub=subdao.getSubjectById(subject_id);
        return new Book(name, description, price, image_url,available,date_launched,sub);
    }

    @Override
    public void addBook(Book book) {
        bookdao.addBook(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookdao.getBookById(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookdao.getBooks();
    }

    @Override
    public List<Book> getBooksBySubjectId(Long id) {
        return bookdao.getBooksBySubject(id);
    }

    @Override
    public void updateBook(Book book) {
        bookdao.updateBook(book);
    }

    @Override
    public void deleteBook(Long id) {
    bookdao.deleteBook(id);
    }
}
