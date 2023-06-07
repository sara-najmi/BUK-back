package com.sbuk.shopping.cart.service;

import com.sbuk.shopping.cart.controller.CartModel;
import com.sbuk.shopping.cart.orm.Cart;
import com.sbuk.shopping.cart.orm.CartItem;
import com.sbuk.shopping.cart.orm.CartItemRepository;
import com.sbuk.shopping.cart.orm.CartRepository;
import com.sbuk.shopping.product.orm.Product;
import com.sbuk.shopping.product.orm.ProductRepository;
import com.sbuk.shopping.user.orm.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    private final CartItemRepository cartItemRepository;

    private final ProductRepository productRepository;

    @Override
    public CartModel addToCart(CartModel cartModel) {
        Cart cart = cartRepository.findByUserIdAndIsPayed(cartModel.getUserId(), false);
        if (cart != null) {
            CartItem cartItem =
                    cartItemRepository.findByCartIdAndProductId(cart.getId(), cartModel.getProductId());
            if (cartItem != null) {
                cartItem.setCount(cartItem.getCount() + cartModel.getCount());
                cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            } else {
                cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setCount(cartModel.getCount());
                cartRepository.save(cart);
                Product product = productRepository.findById(cartModel.getProductId()).get();
                cartItem.setPrice(product.getPrice());
                cartItem.setTotalPrice(product.getPrice());
                cartItem.setProduct(product);
            }
            cartItemRepository.save(cartItem);
        } else {
            cart = new Cart();
            cart.setUser(userRepository.findById(cartModel.getUserId()).get());
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setCount(cartModel.getCount());
            cartRepository.save(cart);
            Product product = productRepository.findById(cartModel.getProductId()).get();
            cartItem.setPrice(product.getPrice());
            cartItem.setTotalPrice(product.getPrice());
            cartItem.setProduct(product);
            cartItemRepository.save(cartItem);
        }
        return cartModel;
    }

    @Override
    public CartModel deleteFromCart(CartModel cartModel) {
        CartItem cartItem =
                cartItemRepository.findByCartUserIdAndProductId(cartModel.getUserId(), cartModel.getProductId());
        cartItemRepository.delete(cartItem);
        return cartModel;
    }
}
