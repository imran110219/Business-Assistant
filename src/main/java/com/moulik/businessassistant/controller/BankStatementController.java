package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.dto.BankStatementDTO;
import com.moulik.businessassistant.dto.ProductDTO;
import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.BankStatementService;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.BankStatement;
import com.moulik.businessassistant.model.BankStatement;
import com.moulik.businessassistant.model.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BankStatementController {

    private final BankStatementService bankStatementService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/bankstatements")
    public String getBankStatement(Model model) {
        List<BankStatementDTO> list = bankStatementService.getAllBankStatements().stream().map(bankStatement -> modelMapper.map(bankStatement, BankStatementDTO.class)).collect(Collectors.toList());
        model.addAttribute("bankStatements", list);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("bankStatement", new BankStatementDTO());
        return "bank-statement";
    }

    @PostMapping("/bankstatements/add")
    public ResponseEntity<String> addBankStatement(BankStatementDTO bankStatementDTO){
        bankStatementService.createBankStatement(modelMapper.map(bankStatementDTO, BankStatement.class));
        return new ResponseEntity<>("BankStatement is added successfully", HttpStatus.OK);
    }

    @GetMapping("/bankstatements/{id}")
    public ResponseEntity<BankStatementDTO> getBankStatementById(@PathVariable(value = "id") Long bankStatementId)
            throws RecordNotFoundException {
        BankStatementDTO bankStatementDTO = modelMapper.map(bankStatementService.getBankStatementById(bankStatementId), BankStatementDTO.class);
        return ResponseEntity.ok(bankStatementDTO);
    }

    @PutMapping("/bankstatements/edit/{id}")
    public ResponseEntity<String> editBankStatementById(@RequestBody BankStatementDTO newBankStatementDTO, @PathVariable(value = "id") Long bankStatementId) {
        bankStatementService.updateBankStatement(modelMapper.map(newBankStatementDTO, BankStatement.class), bankStatementId);
        return new ResponseEntity<>("BankStatement is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/bankstatements/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBankStatementById(@PathVariable(value = "id") Long bankStatementId){
        bankStatementService.deleteBankStatementById(bankStatementId);
        return new ResponseEntity<>("BankStatement is Deleted Successfully", HttpStatus.OK);
    }
}
