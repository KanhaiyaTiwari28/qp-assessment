package com.qp.grocerybooking.service;

import com.qp.grocerybooking.dto.UserDto;
import com.qp.grocerybooking.entity.Role;
import com.qp.grocerybooking.entity.User;
import com.qp.grocerybooking.repository.UserRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRespository userRespository;
    @Autowired
    RoleService roleService;
    public User crateUser(UserDto userDto){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        Role role = roleService.getRoleByName(userDto.getRoleType());
        user.setUserRole(role);
        return  userRespository.save(user);
    }

    public User getUser(String userName, String password){
       return userRespository.findUserByUserNameAndPassword(userName, password);

    }
}
