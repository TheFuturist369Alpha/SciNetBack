package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserAPI {
    private UserService service;

    public UserAPI(UserService service){
        this.service=service;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long id){
        return service.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/updateuser")
    public void updateUser(@RequestBody User user){
        User auser=service.getUserById(user.getId());
        auser.setFirstName(user.getFirstName());
        auser.setLastName(user.getLastName());
        auser.setPassword(user.getPassword());
        auser.setEmail(user.getEmail());
        auser.setImage(user.getImage());
        service.updateUser(auser);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@RequestParam Long id){
        service.deleteUser(id);
    }

}
