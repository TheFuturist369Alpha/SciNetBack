
package com.jalvis.SciNet.daocrud.interfaces.custom;

import com.jalvis.SciNet.entities.User;

import java.util.List;

public interface UserCustomDAO {
    public User getUserById(Long id);
    public List<User> getUsers();
    public void addUser(User user);
    public void updateUser( User user);
    public void deleteUser(Long id);


}

