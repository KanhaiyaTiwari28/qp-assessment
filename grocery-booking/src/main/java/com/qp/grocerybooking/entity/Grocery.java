package com.qp.grocerybooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grocery")
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groceryId;

    @Column
    private String groceryName;

    @Column
    private Double groceryPrice;

    @Column
    private Long quantity;
}
