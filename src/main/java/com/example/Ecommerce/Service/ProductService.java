package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getOrderedProducts(String orderId);
}
