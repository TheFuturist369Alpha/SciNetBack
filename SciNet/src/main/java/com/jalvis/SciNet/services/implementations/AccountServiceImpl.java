package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.AccountService;
import com.jalvis.SciNet.services.interfaces.UserService;
import com.jalvis.SciNet.utils.EmailValidator;
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
    public boolean login(Luser luser) {

        return service.getByPasswordAndEmail(luser)!=null;
    }
}
