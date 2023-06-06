package com.sbuk.shopping.product.controller;

import com.sbuk.shopping.utility.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel extends GenericEntity {
    private Integer id;
    private String title;
    private BigDecimal price;
    private Boolean isActive;

    private List<ImageModel> images;

}
