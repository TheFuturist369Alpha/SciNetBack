package com.jalvis.SciNet.daocrud.implementations;

import com.jalvis.SciNet.daocrud.interfaces.custom.BookCustomDAO;
import com.jalvis.SciNet.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookCustomDAO {

    private EntityManager entityManager;

    @Autowired
    BookDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public Book getBookById(Long id){
      Book book=entityManager.find(Book.class,id);
      return book;
    }

    @Override
    public List<Book> getBooks() {
        TypedQuery<Book> query=entityManager.createQuery("FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksBySubject(Long id) {
        TypedQuery<Book> query=entityManager.createQuery("FROM Book b WHERE b.subject.id=:data", Book.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksByOwnerId(Long id){
        TypedQuery<Book> query=entityManager.createQuery("FROM Book b WHERE b.user.id=:data", Book.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
    entityManager.persist(book);
    }

    @Override
    @Transactional
    public void updateBook( Book book) {

        Book b=getBookById(book.getId());
        entityManager.merge(bookGetterSetter(b,book));

    }

    @Override
    @Transactional
    public void updateBooks(List<Book> books) {
        for(Book book:books){
            Book b=getBookById(book.getId());
            entityManager.merge(bookGetterSetter(b,book));
        }
    }


    @Override
    @Transactional
    public void deleteBook(Long id) {
    Book book=entityManager.find(Book.class, id);
    entityManager.remove(book);
    }

    private Book bookGetterSetter(Book set, Book get){
        set.setName(get.getName());
        set.setDescription(get.getDescription());
        set.setUser(get.getUser());
        set.setAvailable(get.isAvailable());
        set.setDate_launched(get.getDate_launched());
        set.setPrice(get.getPrice());
        set.setImage_url(get.getImage_url());
        set.setSubject(get.getSubject());
        return set;
    }


}
