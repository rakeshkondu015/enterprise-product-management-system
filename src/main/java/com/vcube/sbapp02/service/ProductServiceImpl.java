package com.vcube.sbapp02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.sbapp02.entity.Product;
import com.vcube.sbapp02.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Product updateProduct(Integer id, Product newProduct) {
        Product existing = getProductById(id);

        existing.setName(newProduct.getName());
        existing.setPrice(newProduct.getPrice());
        existing.setQty(newProduct.getQty());

        return productRepo.save(existing);
    }

    @Override
    public Product updatePartialProduct(Integer id, Product newProduct) {
        Product existing = getProductById(id);

        if (newProduct.getName() != null)
            existing.setName(newProduct.getName());

        if (newProduct.getPrice() != null)
            existing.setPrice(newProduct.getPrice());

        if (newProduct.getQty() != null)
            existing.setQty(newProduct.getQty());

        return productRepo.save(existing);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}