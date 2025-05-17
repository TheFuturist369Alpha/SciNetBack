package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface Book_JPA_Repo extends JpaRepository<Book, Long> {
    public Page<Book> findByNameContaining(@Param("name") String name, Pageable page);
    @RestResource(path="byId", rel="byId")
    public Page<Book> findBySubjectId(@Param("id") Long id, Pageable page);
}
