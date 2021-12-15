package com.moulik.businessassistant.dto;

import com.moulik.businessassistant.model.Type;
import com.moulik.businessassistant.model.Unit;
import lombok.*;

import java.util.List;

/**
 * @author Sadman
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Unit unit;
    private String bnName;
    private String sku;
    private double purchasePrice;
    private double salePrice;
    private double percentage;
    private List<Type> productTypes;
}
