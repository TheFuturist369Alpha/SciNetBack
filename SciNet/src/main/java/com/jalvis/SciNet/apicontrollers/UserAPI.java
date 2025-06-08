package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.services.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 @CrossOrigin("https://locahost:4200")
@RestController
@RequestMapping("/userapi")
public class UserAPI {
    private UserService service;

    public UserAPI(UserService service){
        this.service=service;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam long id){
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
        service.updateUser(user);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable long id){
        service.deleteUser(id);
    }

}
