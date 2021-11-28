package com.moulik.businessassistant;

import com.moulik.businessassistant.model.Role;
import com.moulik.businessassistant.model.User;
import com.moulik.businessassistant.repository.InvestmentRepository;
import com.moulik.businessassistant.repository.RoleRepository;
import com.moulik.businessassistant.repository.UserRepository;
import com.moulik.businessassistant.util.DataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author Sadman
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    DataUtil dataUtil;

    @Test
    public void findAllByIdNotContainsTest() {
        List<Double> investUser = investmentRepository.getInvestList();
        for (Double invest : investUser) {
            System.out.println(invest);
        }
    }

    @Test
    public void findColorCodeTest() {
        List<String> colorList = dataUtil.getColorListByNumber(4);
        for (String color : colorList) {
            System.out.println(color);
        }
    }

    @Test
    public void findUserListByRoleTest() {
        List<String> investorList = investmentRepository.getInvestorList();
        for (String investor : investorList){
            System.out.println(investor);
        }
    }
}
