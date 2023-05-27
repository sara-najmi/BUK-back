package com.sbuk.shopping.product.orm;

import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;
}
