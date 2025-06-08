package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="https://localhost:4200")
public interface Subject_JPA_Repo extends JpaRepository<Subject, Integer> {
}
