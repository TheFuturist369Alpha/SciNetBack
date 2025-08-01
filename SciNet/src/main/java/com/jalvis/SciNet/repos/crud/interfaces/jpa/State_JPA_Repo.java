package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins="https://localhost:4200")
@RepositoryRestResource( path="states")
public interface State_JPA_Repo extends JpaRepository<State, Integer> {
    public List<State> findByCountryCode(@Param("code") String code);

}
