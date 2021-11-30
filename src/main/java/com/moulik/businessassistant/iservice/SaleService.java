package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Sale;

import java.util.List;
import java.util.Map;

public interface SaleService {
    List<Sale> getAllSales();

    Sale getSaleById(Long id) throws RecordNotFoundException;

    Sale createSale(Sale sale);

    Sale updateSale(Sale newSale, Long id);

    void deleteSaleById(Long id);

    Map<String, Double> getHighestSale();

    Map<String, Double> getLowestSale();
}
