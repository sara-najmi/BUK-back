package com.sbuk.shopping.product.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private Integer id;
    private String title;
    private BigDecimal price;

}
