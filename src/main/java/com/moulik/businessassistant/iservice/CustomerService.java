package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id) throws RecordNotFoundException;

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer newCustomer, Long id);

    void deleteCustomerById(Long id);
}
