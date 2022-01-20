package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomerById(String customerId);

    Customer addCustomer(Customer aCustomer);

    void deleteCustomerById(String id);

    void updateCustomerInfo(String customer_id, Customer aCustomer);

    List<Customer> whichCustomerHasOrder();
}
