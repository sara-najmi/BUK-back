package com.sbuk.shopping.cart.orm;

import com.sbuk.shopping.product.orm.Product;
import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends GenericEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "product_id"  , referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @JoinColumn(name = "cart_id" , referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
