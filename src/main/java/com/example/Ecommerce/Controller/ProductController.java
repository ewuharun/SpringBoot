package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Service.ProductService;
import com.example.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("api/v1/orderedByCustomer/{id}")
    List<Product> getOrderedProducts(@PathVariable("id") String orderID){
        return productService.getOrderedProducts(orderID);
    }
}
