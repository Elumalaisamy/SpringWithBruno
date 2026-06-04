package com.example.crud.service;

import com.example.crud.model.Product;
import com.example.crud.model.ProductDTO;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductDTO dto);
    Product updateProduct(Long id, ProductDTO dto);
    void deleteProduct(Long id);
    List<Product> searchProducts(String keyword);
}
