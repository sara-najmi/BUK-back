package com.sbuk.shopping.invoice;

import com.sbuk.shopping.cart.orm.Cart;
import com.sbuk.shopping.user.orm.User;
import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "is_delivered")
    private Boolean isDelivered = Boolean.FALSE;
}
