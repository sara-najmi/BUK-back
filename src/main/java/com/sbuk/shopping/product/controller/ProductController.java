package com.sbuk.shopping.product.controller;

import com.sbuk.shopping.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public record ProductController(ProductService productService) {


    @GetMapping("")
    public List<ProductModel> list() throws Exception {
        return productService.list();
    }

    @GetMapping("/{id}")
    public ProductModel find(@PathVariable Integer id) {
        return productService.find(id);
    }

    @PostMapping("")
    public ProductModel create(ProductModel productModel) throws Exception {
        return productService.create(productModel);
    }
}
