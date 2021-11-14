package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.IncomeService;
import com.moulik.businessassistant.model.Income;
import com.moulik.businessassistant.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @Override
    public Income getIncomeById(Long id) throws RecordNotFoundException {
        return incomeRepository.getById(id);
    }

    @Override
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Income newIncome, Long id) {
        return incomeRepository.findById(id)
                .map(income -> {
                    income.setUser(newIncome.getUser());
                    income.setCustomer(newIncome.getCustomer());
                    income.setDeliveryCost(newIncome.getDeliveryCost());
                    income.setDiscount(newIncome.getDiscount());
                    income.setSeller(newIncome.getSeller());
                    income.setTotal(newIncome.getTotal());
                    income.setDatetime(newIncome.getDatetime());
                    return incomeRepository.save(income);
                })
                .orElseGet(() -> {
                    newIncome.setId(id);
                    return incomeRepository.save(newIncome);
                });
    }

    @Override
    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }
}
