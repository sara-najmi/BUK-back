package com.sbuk.shopping.invoice;

import com.sbuk.shopping.cart.controller.CartModel;
import com.sbuk.shopping.user.controller.UserModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvoiceModel {

    private Integer id;

    private UserModel user;

    private CartModel cart;

    private BigDecimal total;

    private Date createAt;

    private Boolean isDelivered;
}
