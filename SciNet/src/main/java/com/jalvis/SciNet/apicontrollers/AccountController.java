package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.Luser;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.AccountService;
import com.jalvis.SciNet.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="https://localhost:4200")
@RestController
@RequestMapping("/account")
public class AccountController {
private AccountService service;
private UserService userService;


//Todo: read cookies for every request
@Autowired
public AccountController(AccountService service, UserService userService){this.service=service;
        this.userService=userService;}

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
    return this.service.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Luser luser){
    User user=(User)this.userService.getByPasswordAndEmail(luser);
            if(user!=null) {
                return ResponseEntity
                        .ok()
                        .header(HttpHeaders.SET_COOKIE, this.service.login(luser).toString())
                        .body(user);

            }
            return ResponseEntity
                .badRequest().body(null);
    }

}
