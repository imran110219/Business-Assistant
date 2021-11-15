package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.ProductTypeService;
import com.moulik.businessassistant.model.ProductType;
import com.moulik.businessassistant.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getProductTypeById(Long id) throws RecordNotFoundException {
        return productTypeRepository.getById(id);
    }

    @Override
    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public ProductType updateProductType(ProductType newProductType, Long id) {
        return productTypeRepository.findById(id)
                .map(productType -> {
                    productType.setProduct(newProductType.getProduct());
                    productType.setType(newProductType.getType());
                    return productTypeRepository.save(productType);
                })
                .orElseGet(() -> {
                    newProductType.setId(id);
                    return productTypeRepository.save(newProductType);
                });
    }

    @Override
    public void deleteProductTypeById(Long id) {
        productTypeRepository.deleteById(id);
    }
}
