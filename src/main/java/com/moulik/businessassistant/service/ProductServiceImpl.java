package com.moulik.businessassistant.service;

import com.moulik.businessassistant.dto.ProductDTO;
import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ProductService;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.Type;
import com.moulik.businessassistant.model.User;
import com.moulik.businessassistant.repository.ProductRepository;
import com.moulik.businessassistant.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final TypeRepository typeRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws RecordNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));

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
                    product.setSku(newProduct.getSku());
                    product.setPercentage(newProduct.getPercentage());
                    product.setPurchasePrice(newProduct.getPurchasePrice());
                    product.setSalePrice(newProduct.getSalePrice());
                    product.setUnit(newProduct.getUnit());
                    product.setTypes(newProduct.getTypes());
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
