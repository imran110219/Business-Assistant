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
    private final CustomerRepository CustomerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return CustomerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) throws RecordNotFoundException {
        return CustomerRepository.getById(id);
    }

    @Override
    public Customer createCustomer(Customer Customer) {
        return CustomerRepository.save(Customer);
    }

    @Override
    public Customer updateCustomer(Customer newCustomer, Long id) {
        return CustomerRepository.findById(id)
                .map(Customer -> {
                    Customer.setFullName(newCustomer.getFullName());
                    Customer.setAddress(newCustomer.getAddress());
                    Customer.setEmail(newCustomer.getEmail());
                    Customer.setPhone(newCustomer.getPhone());
                    return CustomerRepository.save(Customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return CustomerRepository.save(newCustomer);
                });
    }

    @Override
    public void deleteCustomerById(Long id) {
        CustomerRepository.deleteById(id);
    }
}
