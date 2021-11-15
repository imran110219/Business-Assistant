package com.moulik.businessassistant.controller.api;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.CustomerService;
import com.moulik.businessassistant.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(Model model) {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws RecordNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/edit/{id}")
    public Customer editCustomerById(@RequestBody Customer newCustomer, @PathVariable(value = "id") Long customerId) {
        return customerService.updateCustomer(newCustomer, customerId);
    }

    @DeleteMapping("/customers/delete/{id}")
    public void deleteCustomerById(@PathVariable(value = "id") Long customerId){
        customerService.deleteCustomerById(customerId);
    }
}
