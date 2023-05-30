package com.sbuk.shopping.product.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {
    private Integer id;
    private String title;
    private BigDecimal price;

}
