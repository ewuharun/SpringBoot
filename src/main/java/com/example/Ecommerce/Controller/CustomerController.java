package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Service.CustomerService;
import com.example.Ecommerce.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("api/v1/allCustomer")
    List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("api/v1/findCustomerById/{id}")
    Customer getCustomerById(@PathVariable("id")String customerId){
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("api/v1/addCustomer")
    Customer addCustomer(@RequestBody Customer aCustomer){
       return customerService.addCustomer(aCustomer);
    }

    @DeleteMapping("api/v1/deleteCustomerById/{id}")
    void deleteCustomerById(@PathVariable("id") String id){
        customerService.deleteCustomerById(id);
    }

    @PutMapping("api/v1/updateCustomerById/{id}")
    void updateCustomerInfo(@PathVariable("id")String customer_id, @RequestBody Customer aCustomer){
        customerService.updateCustomerInfo(customer_id,aCustomer);
    }

    @GetMapping("api/v1/ordersOfAllCustomer")
    List<Customer> whichCustomerHasOrder(){
        return customerService.whichCustomerHasOrder();
    }

}
