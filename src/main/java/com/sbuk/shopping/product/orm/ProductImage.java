package com.sbuk.shopping.product.orm;

import com.sbuk.shopping.utility.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage extends GenericEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Lob
    @Column(name = "image",columnDefinition = "clob")
    private String image;
}
