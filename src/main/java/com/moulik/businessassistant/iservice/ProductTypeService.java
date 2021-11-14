package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAllProductTypes();

    ProductType getProductTypeById(Long id) throws RecordNotFoundException;

    ProductType createProductType(ProductType productType);

    ProductType updateProductType(ProductType newProductType, Long id);

    void deleteProductTypeById(Long id);
}
