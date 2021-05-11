package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = Arrays.asList(
            new Customer(1, "Joe Bloggs"),
            new Customer(2, "Jane Doe"));
    private OrderClient orderClient;

    public CustomerController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }
    
    @GetMapping("/{id}/orders")
    public Object getOrdersForCustomer(@PathVariable int id) {
        return orderClient.getOrdersForCustomer(id);
    }
    
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
    
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customers.stream()
                        .filter(customer -> customer.getId() == customerId)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
}