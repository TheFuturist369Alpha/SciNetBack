package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.daocrud.interfaces.custom.UserCustomDAO;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserCustomDAO dao;

    @Autowired
    public UserServiceImpl(UserCustomDAO dao){this.dao=dao;}
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }
}
