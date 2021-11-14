package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.CustomerService;
import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) throws RecordNotFoundException {
        return customerRepository.getById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer newCustomer, Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFullName(newCustomer.getFullName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPhone(newCustomer.getPhone());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
