package com.qp.grocerybooking.controller;

import com.qp.grocerybooking.dto.RoleDto;
import com.qp.grocerybooking.entity.Role;
import com.qp.grocerybooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Role createRole(@RequestBody RoleDto roleDto){
        return roleService.createRole(roleDto);
    }

}
