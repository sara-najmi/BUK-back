package com.sbuk.shopping.cart.service;

import com.sbuk.shopping.cart.controller.CartModel;

public interface CartService {

    CartModel addToCart(CartModel cartModel);

    CartModel deleteFromCart(CartModel cartModel);
}
