package com.example.Ecommerce.Service;

import com.example.Ecommerce.Repository.CustomerRepository;
import com.example.Ecommerce.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList();
        customerRepository.findAll().forEach(aCustomer->list.add(aCustomer));
        return list;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer aCustomer) {
        return customerRepository.save(aCustomer);
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomerInfo(String customer_id, Customer aCustomer) {
        Customer customer = customerRepository.findById(customer_id).orElse(null);
        customer.setCustomer_id(customer_id);
        customer.setCustomer_name(aCustomer.getCustomer_name());
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> whichCustomerHasOrder() {
        return customerRepository.whichCustomerHasOrder();
    }
}

