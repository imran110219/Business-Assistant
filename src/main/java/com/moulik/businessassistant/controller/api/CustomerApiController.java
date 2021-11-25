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
public class CustomerApiController {

    private final CustomerService CustomerService;

    @GetMapping("/Customers")
    public List<Customer> getAllCustomers(Model model) {
        return CustomerService.getAllCustomers();
    }

    @GetMapping("/Customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long CustomerId)
            throws RecordNotFoundException {
        Customer Customer = CustomerService.getCustomerById(CustomerId);
        return ResponseEntity.ok().body(Customer);
    }

    @PostMapping("/Customers")
    public Customer createCustomer(@Valid @RequestBody Customer Customer) {
        return CustomerService.createCustomer(Customer);
    }

    @PutMapping("/Customers/edit/{id}")
    public Customer editCustomerById(@RequestBody Customer newCustomer, @PathVariable(value = "id") Long CustomerId) {
        return CustomerService.updateCustomer(newCustomer, CustomerId);
    }

    @DeleteMapping("/Customers/delete/{id}")
    public void deleteCustomerById(@PathVariable(value = "id") Long CustomerId){
        CustomerService.deleteCustomerById(CustomerId);
    }
}
