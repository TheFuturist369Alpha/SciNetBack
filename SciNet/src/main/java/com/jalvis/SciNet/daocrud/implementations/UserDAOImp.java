package com.jalvis.SciNet.daocrud.implementations;

import com.jalvis.SciNet.daocrud.interfaces.custom.UserCustomDAO;
import com.jalvis.SciNet.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserCustomDAO {
    private EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager manager){
        entityManager=manager; }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query=entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
      entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        //TypedQuery<User> query=entityManager.createQuery("FROM User s WHERE s.id=:data", User.class);
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user=entityManager.find(User.class, id);
        entityManager.merge(user);
    }
}
