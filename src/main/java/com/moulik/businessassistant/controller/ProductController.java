package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ProductService;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.Unit;
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
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("product", new Product());
        model.addAttribute("products", list);
        return "product";
    }

    @PostMapping(value="/products/add")
    public ResponseEntity<String> addProduct(Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product is added successfully", HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
            throws RecordNotFoundException {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/edit/{id}")
    public ResponseEntity<String> editProductById(@RequestBody Product newProduct, @PathVariable(value = "id") Long productId) {
        productService.updateProduct(newProduct, productId);
        return new ResponseEntity<>("Product is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") Long productId){
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Product is Deleted Successfully", HttpStatus.OK);
    }
}
