package com.qp.grocerybooking.dto;


import lombok.Data;

import java.util.Date;

@Data
public class RoleDto {
    private String roleType;
    private Date createdAt;
}
