package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.InvestmentService;
import com.moulik.businessassistant.model.Investment;
import com.moulik.businessassistant.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestmentServiceImpl implements InvestmentService {
    private final InvestmentRepository investmentRepository;

    @Override
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public Investment getInvestmentById(Long id) throws RecordNotFoundException {
        return investmentRepository.getById(id);
    }

    @Override
    public Investment createInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    @Override
    public Investment updateInvestment(Investment newInvestment, Long id) {
        return investmentRepository.findById(id)
                .map(investment -> {
                    investment.setInvestor(newInvestment.getInvestor());
                    investment.setAmount(newInvestment.getAmount());
                    investment.setDatetime(newInvestment.getDatetime());
                    return investmentRepository.save(investment);
                })
                .orElseGet(() -> {
                    newInvestment.setId(id);
                    return investmentRepository.save(newInvestment);
                });
    }

    @Override
    public void deleteInvestmentById(Long id) {
        investmentRepository.deleteById(id);
    }

    @Override
    public List<Double> getInvestList() {
        return investmentRepository.getInvestList();
    }

    @Override
    public List<String> getInvestorList() {
        return investmentRepository.getInvestorList();
    }
}
