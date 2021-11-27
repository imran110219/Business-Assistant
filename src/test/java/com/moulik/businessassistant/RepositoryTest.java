package com.moulik.businessassistant;

import com.moulik.businessassistant.repository.InvestmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Sadman
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Test
    public void findAllByIdNotContainsTest() {
        List<Double> investUser = investmentRepository.getInvestUserList();
        for (Double invest : investUser) {
            System.out.println(invest);
        }
    }
}
