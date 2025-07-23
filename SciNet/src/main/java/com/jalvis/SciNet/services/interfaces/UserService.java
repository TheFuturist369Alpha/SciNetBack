package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void loginUser(Luser luser);
    public User getUserById(Long id);
    //public User getUserByEmail(String email);
    public List<User> getUsers();
    public UserDetails getByPasswordAndEmail(Luser luser);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public boolean signUpUser(User user);

}
