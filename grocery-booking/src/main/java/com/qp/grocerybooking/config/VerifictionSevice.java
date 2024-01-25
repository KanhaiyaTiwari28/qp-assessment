package com.qp.grocerybooking.config;

import com.qp.grocerybooking.entity.User;
import com.qp.grocerybooking.exception.InvalidUserException;
import com.qp.grocerybooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifictionSevice {

    @Autowired
    UserService userService;

    public String verifyRole(String userName, String passWord){
       User user = userService.getUser(userName, passWord);
        if(user == null)
            throw new InvalidUserException("Invalid user credentials");

       return user.getUserRole().getRoleType();
    }
}
