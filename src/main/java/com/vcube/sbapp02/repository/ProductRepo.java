package com.vcube.sbapp02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.sbapp02.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findByName(String name); // follow camelCase
}