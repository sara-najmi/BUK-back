package com.sbuk.shopping.cart.controller;

import lombok.Data;
import org.hibernate.id.IntegralDataTypeHolder;

@Data
public class CartModel {

    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer count;
}
