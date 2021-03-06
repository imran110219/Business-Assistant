package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.dto.ProductDTO;
import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ProductService;
import com.moulik.businessassistant.iservice.TypeService;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.mappers.ProductMapper;
import com.moulik.businessassistant.model.*;
import com.moulik.businessassistant.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;
    private final TypeService typeService;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> list = productService.getAllProducts();
        List<Type> typeList = typeService.getAllTypes();
        Set<Type> typeSet = new HashSet<>(typeList);
        model.addAttribute("product", new Product());
        model.addAttribute("productdto", new ProductDTO());
        model.addAttribute("products", list);
        model.addAttribute("typelist", typeList);
        model.addAttribute("typeset", typeSet);
        return "product";
    }

    @PostMapping(value="/products/add")
    public ResponseEntity<String> addProduct(Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product is added successfully", HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") Long productId)
            throws RecordNotFoundException {
        ProductDTO productDTO = productMapper.modelToDTO(productService.getProductById(productId));
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/products/edit/{id}")
    public ResponseEntity<String> editProductById(@RequestBody ProductDTO newProductDTO, @PathVariable(value = "id") Long productId) {
        Product newProduct = productMapper.dtoToModel(newProductDTO);
        productService.updateProduct(newProduct, productId);
        return new ResponseEntity<>("Product is edited successfully", HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") Long productId){
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Product is Deleted Successfully", HttpStatus.OK);
    }
}
