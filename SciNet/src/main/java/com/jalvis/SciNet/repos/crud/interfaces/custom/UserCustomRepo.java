
package com.jalvis.SciNet.repos.crud.interfaces.custom;

import com.jalvis.SciNet.entities.User;

import java.util.List;

public interface UserCustomRepo {
    public User getUserById(Long id);
    public User getUserByEmail(String email);
    public List<User> getUsers();
    public void addUser(User user);
    public void updateUser( User user);
    public void deleteUser(Long id);


}

