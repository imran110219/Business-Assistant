package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ProductService;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws RecordNotFoundException {
        return productRepository.getById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setBnName(newProduct.getBnName());
                    product.setPercentage(newProduct.getPercentage());
                    product.setPurchasePrice(newProduct.getPurchasePrice());
                    product.setSalePrice(newProduct.getSalePrice());
                    product.setUnitId(newProduct.getUnitId());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
