package com.vcube.sbapp02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vcube.sbapp02.entity.Product;
import com.vcube.sbapp02.service.ProductService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CREATE
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // READ ALL
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // READ BY ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    // READ BY NAME
    @GetMapping("/products/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    // UPDATE (PUT)
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // PARTIAL UPDATE (PATCH)
    @PatchMapping("/products/{id}")
    public Product updatePartialProduct(@PathVariable ("id") Integer id, @RequestBody Product product) {
        return productService.updatePartialProduct(id, product);
    }

    // DELETE
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}