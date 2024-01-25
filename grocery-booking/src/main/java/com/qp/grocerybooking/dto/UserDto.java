package com.qp.grocerybooking.dto;

import com.qp.grocerybooking.entity.Role;
import lombok.Data;


import java.util.Date;

@Data
public class UserDto {

    private String userName;

    private String password;

    private Date createdAt;

    private String roleType;
}
