package arias.huapaya.digital.peru.money.track.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarIncomeExpenseDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionPaginationDTO;
import arias.huapaya.digital.peru.money.track.service.TransactionService;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransactionCreateDTO transaction) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", this.transactionService.create(transaction));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "pagination/{userId}")
    public ResponseEntity<?> pagination(@PathVariable Long userId, @RequestParam(required = false) String search,
            Pageable pageable) {
        PageDTO<TransactionPaginationDTO> transactionPage = null;
        transactionPage = this.transactionService.pagination(userId, search, pageable);
        return new ResponseEntity<>(transactionPage, HttpStatus.OK);
    }

    @GetMapping("balance/{userId}")
    public ResponseEntity<?> getBalanceByUserId(@PathVariable Long userId) {
        TransactionBalanceDTO transactionBalance = this.transactionService.getBalanceByUserId(userId);
        return new ResponseEntity<>(transactionBalance, HttpStatus.OK);
    }

    @GetMapping("dashboard/bar/{userId}")
    public ResponseEntity<?> getTransactionBarByUserId(@PathVariable Long userId) {
        List<TransactionBarDTO>  transactionBarList = this.transactionService.getTransactionBarByUserId(userId);
        return new ResponseEntity<>(transactionBarList, HttpStatus.OK);
    }

    @GetMapping("dashboard/bar/{userId}/type/{type}")
    public ResponseEntity<?> getTransactionBarIncomeExpenseByUserIdAndType(@PathVariable Long userId, @PathVariable String type) {
        List<TransactionBarIncomeExpenseDTO>  transactionBarList = this.transactionService.getTransactionBarIncomeExpenseByUserIdAndType(userId, type);
        return new ResponseEntity<>(transactionBarList, HttpStatus.OK);
    }

}
