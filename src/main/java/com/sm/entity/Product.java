package com.sm.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("productFilter")
public class Product {

    private Long id;
    private String name;
    private int quantity;
    private double price;

}
