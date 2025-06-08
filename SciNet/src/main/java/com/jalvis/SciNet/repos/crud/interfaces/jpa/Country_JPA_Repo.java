package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="https://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path="countries")
public interface Country_JPA_Repo extends JpaRepository<Country, Integer> {

}
