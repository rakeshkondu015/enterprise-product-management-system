package com.vcube.sbapp02.service;

import java.util.List;
import com.vcube.sbapp02.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    Product getProductByName(String name);

    Product updateProduct(Integer id, Product product);

    Product updatePartialProduct(Integer id, Product product);

    void deleteProduct(Integer id);
}