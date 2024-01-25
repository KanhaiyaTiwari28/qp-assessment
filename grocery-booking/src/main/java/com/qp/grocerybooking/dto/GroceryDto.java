package com.qp.grocerybooking.dto;

import lombok.Data;

@Data
public class GroceryDto {

    private String groceryName;

    private Double groceryPrice;

    private Long quantity;
}
