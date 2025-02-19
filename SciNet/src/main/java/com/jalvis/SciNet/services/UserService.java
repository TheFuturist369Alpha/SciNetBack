package com.jalvis.SciNet.services;

import com.jalvis.SciNet.entities.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User getUserById(Long id);
    public List<User> getUsers();
    public void updateUser(User user);
    public void deleteUser(Long id);
}
