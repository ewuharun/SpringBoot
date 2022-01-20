package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,String> {

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update customer set customer_name = "+"harunupdate"+" where customer_id = 1")
//    void updateCustomerInfo(String customer_id,Customer aCustomer);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select Distinct(c.customer_id),c.customer_name from customer as c inner join orders on orders.customer_id = c.customer_id",nativeQuery = true)
    List<Customer> whichCustomerHasOrder();
}
