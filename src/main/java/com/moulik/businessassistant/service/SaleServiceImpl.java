package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.SaleService;
import com.moulik.businessassistant.model.Sale;
import com.moulik.businessassistant.repository.SaleRepository;
import com.moulik.businessassistant.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) throws RecordNotFoundException {
        return saleRepository.getById(id);
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(Sale newSale, Long id) {
        return saleRepository.findById(id)
                .map(sale -> {
                    sale.setIncome(newSale.getIncome());
                    sale.setDiscount(newSale.getDiscount());
                    sale.setQuantity(newSale.getQuantity());
                    sale.setStock(newSale.getStock());
                    sale.setUnit(newSale.getUnit());
                    sale.setDatetime(newSale.getDatetime());
                    sale.setTotal(newSale.getTotal());
                    sale.setDatetime(newSale.getDatetime());
                    sale.setUnitPrice(newSale.getUnitPrice());
                    return saleRepository.save(sale);
                })
                .orElseGet(() -> {
                    newSale.setId(id);
                    return saleRepository.save(newSale);
                });
    }

    @Override
    public void deleteSaleById(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Map<String, Double> getHighestSale(){
        Map<String,Double> map = DataUtil.convertMapToMap(saleRepository.getHighestSale());
        Map<String,Double>  sortedMapReverseOrder =  map.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMapReverseOrder);
        return sortedMapReverseOrder;
    }

    @Override
    public Map<String, Double> getLowestSale(){
        Map<String,Double> map = DataUtil.convertMapToMap(saleRepository.getHighestSale());
        Map<String,Double>  sortedMap =  map.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        return sortedMap;
    }
}
