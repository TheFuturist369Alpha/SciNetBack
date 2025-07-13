package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
private AccountService service;

@Autowired
public AccountController(AccountService service){this.service=service;}

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
    return this.service.register(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        Luser luser=user.toLuser();
    return this.service.login(luser);
    }

}
