package com.example.UserQuerySystem.Controller;

import com.example.UserQuerySystem.Entity.UserEntity;
import com.example.UserQuerySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        userService.saveOrUpdate(user);
        return user;
    }

    @GetMapping(value = "/getAll")
    public Iterable<UserEntity> getUsers() {
        return userService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable(name = "id") String id) {
        user.set_id(id);
        userService.saveOrUpdate(user);
        return user;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }

    @GetMapping(value = "/search/{id}")
    public UserEntity getUser(@PathVariable(name = "id") String userId) {
        return userService.getUserByID(userId);
    }
}
