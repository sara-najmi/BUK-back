package com.sbuk.shopping.product.service;

import com.sbuk.shopping.product.controller.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> list() throws Exception;

    ProductModel find(Integer id);
    ProductModel create(ProductModel productModel) throws Exception;
}
