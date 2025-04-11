package com.jalvis.SciNet.repos.crud.interfaces.jpa;

import com.jalvis.SciNet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_JPA_Repo extends JpaRepository<User, Long> {
}
