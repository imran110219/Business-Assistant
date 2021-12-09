package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.StockService;
import com.moulik.businessassistant.model.Stock;
import com.moulik.businessassistant.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) throws RecordNotFoundException {
        return stockRepository.getById(id);
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock newStock, Long id) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setPurchase(newStock.getPurchase());
                    stock.setStore(newStock.getStore());
                    stock.setQuantity(newStock.getQuantity());
                    stock.setUnit(newStock.getUnit());
                    stock.setDatetime(newStock.getDatetime());
                    return stockRepository.save(stock);
                })
                .orElseGet(() -> {
                    newStock.setId(id);
                    return stockRepository.save(newStock);
                });
    }

    @Override
    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }
}
