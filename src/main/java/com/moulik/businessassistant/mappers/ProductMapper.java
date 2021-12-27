package com.moulik.businessassistant.mappers;

import com.moulik.businessassistant.dto.ProductDTO;
import com.moulik.businessassistant.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Sadman
 */
public interface ProductMapper {
    Product dtoToModel(ProductDTO productDTO);
    ProductDTO modelToDTO(Product product);
    List<ProductDTO> modelToDTOList(List<Product> productList);
    List<Product> dtoToModelList(List<ProductDTO> productDTOList);
}
