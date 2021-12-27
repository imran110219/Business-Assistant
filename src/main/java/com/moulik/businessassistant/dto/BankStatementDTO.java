package com.moulik.businessassistant.dto;

import com.moulik.businessassistant.model.TransactionType;
import com.moulik.businessassistant.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Sadman
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankStatementDTO {
    private long id;
    private User user;
    private double amount;
    private TransactionType transactionType;
    private Date datetime;
}
