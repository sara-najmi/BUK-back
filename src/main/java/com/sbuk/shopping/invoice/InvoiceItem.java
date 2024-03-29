package com.sbuk.shopping.invoice;

import com.sbuk.shopping.cart.orm.Cart;
import com.sbuk.shopping.cart.orm.CartItem;
import com.sbuk.shopping.product.orm.Product;
import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @JoinColumn(name = "cart_item_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CartItem cartItem;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Invoice invoice;
}
