package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.AccountService;
import com.jalvis.SciNet.services.interfaces.UserService;
import com.jalvis.SciNet.utils.EmailValidator;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private EmailValidator validator=new EmailValidator();
    private UserService service;

    public AccountServiceImpl(UserService service){this.service=service;}

    @Override
    public boolean register(User user) {
        if(!validator.test(user.getEmail()))
            return false;
        return service.signUpUser(user);
    }

    @Override
    public ResponseCookie login(Luser luser) {

        User usr=(User)service.getByPasswordAndEmail(luser);
        if(usr!=null) {
            ResponseCookie rcookie = ResponseCookie.from("user-id", usr.getCookie()).httpOnly(true).maxAge(86400).build();
            return rcookie;
        }
        return null;
    }
}
