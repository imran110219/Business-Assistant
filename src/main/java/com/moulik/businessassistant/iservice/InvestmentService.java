package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Investment;

import java.util.List;

/**
 * @author Sadman
 */
public interface InvestmentService {
    List<Investment> getAllInvestments();

    Investment getInvestmentById(Long id) throws RecordNotFoundException;

    Investment createInvestment(Investment investment);

    Investment updateInvestment(Investment newInvestment, Long id);

    void deleteInvestmentById(Long id);

    List<Double> getInvestList();
}
