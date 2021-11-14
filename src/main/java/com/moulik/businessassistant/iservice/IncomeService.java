package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Income;

import java.util.List;

public interface IncomeService {
    List<Income> getAllIncomes();

    Income getIncomeById(Long id) throws RecordNotFoundException;

    Income createIncome(Income income);

    Income updateIncome(Income newIncome, Long id);

    void deleteIncomeById(Long id);
}
