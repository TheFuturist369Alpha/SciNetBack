package com.jalvis.SciNet.repos.crud.implementations;

import com.jalvis.SciNet.repos.crud.interfaces.custom.UserCustomRepo;
import com.jalvis.SciNet.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserCustomRepo {
    private EntityManager entityManager;

    @Autowired
    public UserRepoImpl(EntityManager manager){
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
        User user1=entityManager.find(User.class, user.getId());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setImage(user.getImage());
        user1.setPassword(user.getPassword());
        user1.setOrders(user.getOrders());
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user=entityManager.find(User.class, id);
        try {
            if (user == null)
                throw new Exception("User of " + id + " does not exist");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        entityManager.remove(user);
    }
}
