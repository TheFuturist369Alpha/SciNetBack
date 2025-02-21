package com.jalvis.SciNet.daocrud.interfaces.jpa;

import com.jalvis.SciNet.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface Book_JPA_DAO extends JpaRepository<Book, Long> {
    public Page<Book> findByNameContaining(@Param("name") String name, Pageable page);
}
