package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.CustomerService;
import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomer(Model model) {
        List<Customer> list = customerService.getAllCustomers();
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers", list);
        return "customer";
    }

    @PostMapping(value="/customers/add")
    public ResponseEntity<String> addCustomer(Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Customer is added successfully", HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws RecordNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customers/edit/{id}")
    public ResponseEntity<String> editCustomerById(@RequestBody Customer newCustomer, @PathVariable(value = "id") Long customerId) {
        customerService.updateCustomer(newCustomer, customerId);
        return new ResponseEntity<>("Customer is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/customers/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteCustomerById(@PathVariable(value = "id") Long customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>("Customer is Deleted Successfully", HttpStatus.OK);
    }
}
