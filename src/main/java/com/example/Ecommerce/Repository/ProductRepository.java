package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,String> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select p.product_id,p.product_name from product as p where p.product_id in (select od.product_id from orders as o inner join orders_details as od on o.order_id = od.order_id where o.order_id = :orderId)",nativeQuery = true)
    List<Product> getOrderedProducts(String orderId);
}
