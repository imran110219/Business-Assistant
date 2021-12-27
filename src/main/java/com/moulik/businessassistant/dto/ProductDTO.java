package com.moulik.businessassistant.dto;

import com.moulik.businessassistant.model.Type;
import com.moulik.businessassistant.model.Unit;
import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * @author Sadman
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private Unit unit;
    private String bnName;
    private String sku;
    private double purchasePrice;
    private double salePrice;
    private double percentage;
    private Set<Type> types;
    private List<Long> productTypeIds;
}
