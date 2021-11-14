package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id) throws RecordNotFoundException;

    Product createProduct(Product product);

    Product updateProduct(Product newProduct, Long id);

    void deleteProductById(Long id);
}
