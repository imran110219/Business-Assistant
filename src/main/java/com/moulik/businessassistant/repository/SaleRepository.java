package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Customer;
import com.moulik.businessassistant.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT stock.purchase.product.name, sum(quantity) FROM Sale group by stock order by quantity desc")
    List<Map<String, Long>> getHighestSale();
}
