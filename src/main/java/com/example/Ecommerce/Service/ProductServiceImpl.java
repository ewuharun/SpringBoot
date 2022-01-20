package com.example.Ecommerce.Service;

import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getOrderedProducts(String orderId) {
        return productRepository.getOrderedProducts(orderId);
    }


}
