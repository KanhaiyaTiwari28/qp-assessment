package com.qp.grocerybooking.controller;

import com.qp.grocerybooking.dto.UserDto;
import com.qp.grocerybooking.entity.User;
import com.qp.grocerybooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserContoller {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody UserDto userDto){
        return userService.crateUser(userDto);
    }
}
