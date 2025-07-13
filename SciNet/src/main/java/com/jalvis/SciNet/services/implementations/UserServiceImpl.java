package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.repos.crud.interfaces.custom.UserCustomRepo;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.repos.crud.interfaces.jpa.User_JPA_Repo;
import com.jalvis.SciNet.services.interfaces.ConfirmationTokenService;
import com.jalvis.SciNet.services.interfaces.UserService;
import com.jalvis.SciNet.entities.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    private UserCustomRepo dao;
    private User_JPA_Repo jdao;
    private PasswordEncoder encoder;
    private ConfirmationTokenService service;

    @Autowired
    public UserServiceImpl(UserCustomRepo dao, User_JPA_Repo jdao, ConfirmationTokenService service, PasswordEncoder endoder)
    {this.dao=dao; this.jdao=jdao; this.encoder=endoder; this.service=service;}
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void loginUser(Luser luser) {

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
    public UserDetails getByPasswordAndEmail(Luser luser) {
        UserDetails usrnm=loadUserByUsername(luser.getEmail());

        if(usrnm!=null){
            String encrypted_password=usrnm.getPassword();
            if(encoder.matches(luser.getPassword(),encrypted_password))
                return loadUserByUsername(luser.getEmail());
            return null;
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {

        try{dao.deleteUser(id);}
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return jdao.findByEmail(username);
    }


    @Override
    public boolean signUpUser(User user){
        if(jdao.findByEmail(user.getEmail())!=null){
             return false;
        }
        String encoded=encoder.encode(user.getPassword());
        user.setPassword(encoded);
        jdao.save(user);

        ConfirmationToken token=new ConfirmationToken(UUID.randomUUID().toString(),
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);
        service.save(token);


        return true;

    }


}
