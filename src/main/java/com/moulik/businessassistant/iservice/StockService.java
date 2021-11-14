package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();

    Stock getStockById(Long id) throws RecordNotFoundException;

    Stock createStock(Stock stock);

    Stock updateStock(Stock newStock, Long id);

    void deleteStockById(Long id);
}
