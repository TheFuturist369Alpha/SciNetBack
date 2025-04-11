package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.repos.crud.interfaces.custom.BookCustomRepo;
import com.jalvis.SciNet.repos.crud.interfaces.custom.SubjectCustomRepo;
import com.jalvis.SciNet.repos.crud.interfaces.custom.UserCustomRepo;
import com.jalvis.SciNet.entities.Book;
import com.jalvis.SciNet.entities.Subject;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final SubjectCustomRepo subdao;
    private final BookCustomRepo bookdao;
    private final UserCustomRepo userdao;

    @Autowired
    public BookServiceImpl(SubjectCustomRepo subdao, BookCustomRepo bookdao, UserCustomRepo userdao)
    {this.subdao=subdao; this.bookdao=bookdao; this.userdao=userdao;}

    @Override
    public  Book createBook( String name, String description, double price,
                             String image_url, boolean available, Date date_launched,
                             Long subject_id, Long user_id) {

        Subject sub=subdao.getSubjectById(subject_id);
        User user=userdao.getUserById(user_id);
        return new Book(name, description, price, image_url,available,date_launched,sub,user);
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
    public List<Book> getBooksByUserId(Long id){return bookdao.getBooksByOwnerId(id);}

    @Override
    public void updateBook(Book book) {
        bookdao.updateBook(book);
    }

    @Override
    public void updateBooks(List<Book> books) {
        bookdao.updateBooks(books);
    }

    @Override
    public void deleteBook(Long id) {
    bookdao.deleteBook(id);
    }
}
