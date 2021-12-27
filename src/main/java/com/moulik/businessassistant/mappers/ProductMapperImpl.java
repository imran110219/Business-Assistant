package com.moulik.businessassistant.mappers;

import com.moulik.businessassistant.dto.BankStatementDTO;
import com.moulik.businessassistant.dto.ProductDTO;
import com.moulik.businessassistant.model.Product;
import com.moulik.businessassistant.model.Type;
import com.moulik.businessassistant.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
@Service
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final TypeRepository typeRepository;

    @Override
    public Product dtoToModel(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setUnit(productDTO.getUnit());
        product.setBnName(productDTO.getBnName());
        product.setSku(productDTO.getSku());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setSalePrice(productDTO.getSalePrice());
        product.setPercentage(productDTO.getPercentage());
        Set<Type> typeSet = new HashSet<>();
        for (Long typeId : productDTO.getProductTypeIds()) {
            typeSet.add(typeRepository.getById(typeId));
        }
        product.setTypes(typeSet);
        return product;
    }

    @Override
    public ProductDTO modelToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setBnName(product.getBnName());
        productDTO.setSku(product.getSku());
        productDTO.setUnit(product.getUnit());
        List<Long> typelist = new ArrayList<>();
        for (Type type : product.getTypes()) {
            typelist.add(type.getId());
        }
        productDTO.setProductTypeIds(typelist);
        productDTO.setTypes(product.getTypes());
        productDTO.setPurchasePrice(product.getPurchasePrice());
        productDTO.setSalePrice(product.getSalePrice());
        productDTO.setPercentage(product.getPercentage());
        return productDTO;
    }

    @Override
    public List<ProductDTO> modelToDTOList(List<Product> productList) {
        return productList
                .stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> dtoToModelList(List<ProductDTO> productDTOList) {
        return productDTOList
                .stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
