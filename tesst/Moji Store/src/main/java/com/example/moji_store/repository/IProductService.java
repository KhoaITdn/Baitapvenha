package com.example.moji_store.repository;

import com.example.moji_store.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAllProducts();

    Optional<Product> findProductById(Long id);
}
