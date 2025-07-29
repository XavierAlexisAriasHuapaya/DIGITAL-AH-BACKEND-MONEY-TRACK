package arias.huapaya.digital.peru.money.track.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arias.huapaya.digital.peru.money.track.interfaces.TransactionImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.TransactionRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarIncomeExpenseDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionPaginationDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionService implements TransactionImpl {

    private final TransactionRepository respository;

    @Override
    public String create(TransactionCreateDTO transaction) {
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .user(transaction.getUser())
                .category(transaction.getCategory())
                .bankAccountOrigin(transaction.getBankAccountOrigin())
                .bankAccountDestination(transaction.getBankAccountDestination())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .build();
        respository.save(transactionEntity);
        return "Transaction created successfully";
    }

    @Override
    public List<TransactionFindAllDTO> findAll() {
        List<TransactionEntity> transactions = this.respository.findAll();
        List<TransactionFindAllDTO> transactionFindAllDTO = new ArrayList<>();
        transactions.forEach(transaction -> {
            TransactionFindAllDTO findAllDTO = TransactionFindAllDTO.builder()
                    .id(transaction.getId())
                    .category(transaction.getCategory())
                    .bankAccountOrigin(transaction.getBankAccountOrigin())
                    .bankAccountDestination(transaction.getBankAccountDestination())
                    .description(transaction.getDescription())
                    .amount(transaction.getAmount())
                    .date(transaction.getDate())
                    .build();
            transactionFindAllDTO.add(findAllDTO);
        });
        return transactionFindAllDTO;
    }

    @Override
    public PageDTO<TransactionPaginationDTO> pagination(Long userId, String search, Pageable pageable) {
        Page<TransactionEntity> transactionPage = this.respository.findByUserIdAndDescriptionContainingIgnoreCase(
                userId,
                search, pageable);
        List<TransactionPaginationDTO> transactionPagination = transactionPage
                .getContent()
                .stream()
                .map(transaction -> new TransactionPaginationDTO(transaction))
                .toList();
        return new PageDTO<>(transactionPagination, transactionPage.getNumber(), transactionPage.getSize(),
                transactionPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    @Override
    public TransactionBalanceDTO getBalanceByUserId(Long userId) {
        return this.respository.getBalanceByUserId(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransactionBarDTO>  getTransactionBarByUserId(Long userId) {
        return this.respository.getTransactionBarByUserId(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransactionBarIncomeExpenseDTO> getTransactionBarIncomeExpenseByUserIdAndType(Long userId, String type) {
        return this.respository.getTransactionBarIncomeExpenseByUserIdAndType(userId, type);
    }
}
