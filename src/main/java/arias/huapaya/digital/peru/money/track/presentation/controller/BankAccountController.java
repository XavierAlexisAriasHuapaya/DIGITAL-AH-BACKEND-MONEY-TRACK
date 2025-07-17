package arias.huapaya.digital.peru.money.track.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindOne;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountUpdateDTO;
import arias.huapaya.digital.peru.money.track.service.BankAccountService;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "bank-account")
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BankAccountCreateDTO bankAccount) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.bankAccountService.create(bankAccount));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody BankAccountUpdateDTO bankAccount) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.bankAccountService.update(bankAccount));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "user/{userId}")
    public ResponseEntity<?> findAll(@PathVariable Long userId) {
        List<BankAccountFindAllDTO> bankAccounts = this.bankAccountService.findAll(userId);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }

    @GetMapping(path = "pagination/{id}")
    public ResponseEntity<?> pagination(@PathVariable Long id, @RequestParam(required = false) String search,
            Pageable pageable) {
        PageDTO<BankAccountPaginationDTO> bankAccountPage = null;
        bankAccountPage = this.bankAccountService.pagination(id, search, pageable);
        return new ResponseEntity<>(bankAccountPage, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        BankAccountFindOne bankAccount = this.bankAccountService.findOne(id);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

}
