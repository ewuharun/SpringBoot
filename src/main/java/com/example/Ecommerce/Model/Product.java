package com.example.Ecommerce.Model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String product_id;
    String product_name;

    public Product(String product_id) {
        this.product_id = product_id;

    }

    public Product(String product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    public Product() {
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
