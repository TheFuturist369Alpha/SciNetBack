package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("https://localhost:4200")
public interface Address_JPA_Repo extends JpaRepository<Address, Long> {
}
