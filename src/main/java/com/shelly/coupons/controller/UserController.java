package com.shelly.coupons.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.shelly.coupons.beans.UserLoginDetails;
import com.shelly.coupons.beans.UserLoginToken;
import com.shelly.coupons.entities.UserEntity;
import com.shelly.coupons.exception.ApplicationException;
import com.shelly.coupons.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserLogic userLogic;

    @Autowired
    public UserController(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    @PostMapping
    public void createUser(@RequestBody UserEntity user) throws ApplicationException {
        userLogic.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserEntity user) throws ApplicationException {
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("id") long id) throws ApplicationException {
        return userLogic.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws ApplicationException {
        userLogic.deleteUser(id);
    }

    @PostMapping("/login")
    public UserLoginToken login(@RequestBody UserLoginDetails userLogin) throws ApplicationException, JsonProcessingException {
        return userLogic.login(userLogin);
    }


}
