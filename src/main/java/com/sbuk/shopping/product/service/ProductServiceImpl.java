package com.sbuk.shopping.product.service;

import com.sbuk.shopping.product.controller.ImageModel;
import com.sbuk.shopping.product.controller.ProductModel;
import com.sbuk.shopping.product.orm.Product;
import com.sbuk.shopping.product.orm.ProductImage;
import com.sbuk.shopping.product.orm.ProductImageRepository;
import com.sbuk.shopping.product.orm.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductImageRepository productImageRepository;


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
        Product product = productRepository.save(convertToEntity(productModel));
        for (ImageModel image : productModel.getImages()) {
            productImageRepository.save(new ProductImage(null, product, image.getImg()));
        }
        return convertToDto(product);
    }

    public static ProductModel convertToDto(Product product) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);
        productModel.setImages(new ArrayList<>());
        if (product.getProductImages() != null) {
            for (ProductImage productImage : product.getProductImages()) {
                productModel.getImages().add(new ImageModel(productImage.getImage()));
            }
        }
        return productModel;
    }

    public Product convertToEntity(ProductModel productModel) {
        Product product = new Product();
        BeanUtils.copyProperties(productModel, product);
        return product;
    }
}
