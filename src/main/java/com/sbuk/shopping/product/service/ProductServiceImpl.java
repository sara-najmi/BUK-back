package com.sbuk.shopping.product.service;

import com.sbuk.shopping.product.controller.ProductModel;
import com.sbuk.shopping.product.orm.Product;
import com.sbuk.shopping.product.orm.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<ProductModel> list() throws Exception {
        return productRepository.findAll()
                .stream()
                .map(ProductServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }


    public static ProductModel convertToDto(Product product) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);
        return productModel;
    }
}
