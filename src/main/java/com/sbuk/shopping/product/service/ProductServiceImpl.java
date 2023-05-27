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

    @Override
    public ProductModel find(Integer id) {
        return convertToDto(productRepository.findById(id).orElseThrow());
    }

    @Override
    public ProductModel create(ProductModel productModel) throws Exception {
        return convertToDto(productRepository.save(convertToEntity(productModel)));
    }

    public static ProductModel convertToDto(Product product) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);
        return productModel;
    }

    public static Product convertToEntity(ProductModel productModel) {
        Product product = new Product();
        BeanUtils.copyProperties(productModel, product);
        return product;
    }
}
