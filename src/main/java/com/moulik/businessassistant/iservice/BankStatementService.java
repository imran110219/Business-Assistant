package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.BankStatement;

import java.util.List;

/**
 * @author Sadman
 */
public interface BankStatementService {
    List<BankStatement> getAllBankStatements();

    BankStatement getBankStatementById(Long id) throws RecordNotFoundException;

    BankStatement createBankStatement(BankStatement bankStatement);

    BankStatement updateBankStatement(BankStatement newBankStatement, Long id);

    void deleteBankStatementById(Long id);
}
