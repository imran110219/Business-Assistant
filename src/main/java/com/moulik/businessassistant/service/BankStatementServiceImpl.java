package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.BankStatementService;
import com.moulik.businessassistant.model.BankStatement;
import com.moulik.businessassistant.repository.BankStatementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankStatementServiceImpl implements BankStatementService {
    private final BankStatementRepository bankStatementRepository;

    @Override
    public List<BankStatement> getAllBankStatements() {
        return bankStatementRepository.findAll();
    }

    @Override
    public BankStatement getBankStatementById(Long id) throws RecordNotFoundException {
        return bankStatementRepository.getById(id);
    }

    @Override
    public BankStatement createBankStatement(BankStatement bankStatement) {
        return bankStatementRepository.save(bankStatement);
    }

    @Override
    public BankStatement updateBankStatement(BankStatement newBankStatement, Long id) {
        return bankStatementRepository.findById(id)
                .map(bankStatement -> {
                    bankStatement.setUser(newBankStatement.getUser());
                    bankStatement.setAmount(newBankStatement.getAmount());
                    bankStatement.setTransactionType(newBankStatement.getTransactionType());
                    bankStatement.setDatetime(newBankStatement.getDatetime());
                    return bankStatementRepository.save(bankStatement);
                })
                .orElseGet(() -> {
                    newBankStatement.setId(id);
                    return bankStatementRepository.save(newBankStatement);
                });
    }

    @Override
    public void deleteBankStatementById(Long id) {
        bankStatementRepository.deleteById(id);
    }
}
