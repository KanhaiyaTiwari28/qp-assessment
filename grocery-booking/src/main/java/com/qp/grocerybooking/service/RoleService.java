package com.qp.grocerybooking.service;

import com.qp.grocerybooking.dto.RoleDto;
import com.qp.grocerybooking.entity.Role;
import com.qp.grocerybooking.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(RoleDto roleDto){
        ModelMapper modelMapper = new ModelMapper();
        Role role = modelMapper.map(roleDto, Role.class);
        return roleRepository.save(role);
    }

    public Role getRoleByName(String roleName){
        return roleRepository.getByRoleType(roleName);
    };
}
