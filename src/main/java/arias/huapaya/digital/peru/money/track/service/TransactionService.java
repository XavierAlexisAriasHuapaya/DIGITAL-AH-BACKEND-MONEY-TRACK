package arias.huapaya.digital.peru.money.track.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arias.huapaya.digital.peru.money.track.interfaces.TransactionImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.TransactionRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindOne;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarIncomeExpenseDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionUpdateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import arias.huapaya.digital.peru.money.track.util.exception.ObjectNotFoundException;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionService implements TransactionImpl {

    private final TransactionRepository respository;

    private final UserService userService;

    private final CategoryService categoryService;

    private final BankAccountService bankAccountService;

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
        return "Successfully created";
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
    public List<TransactionBarDTO> getTransactionBarByUserId(Long userId, String year) {
        return this.respository.getTransactionBarByUserId(userId, year);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransactionBarIncomeExpenseDTO> getTransactionBarIncomeExpenseByUserIdAndType(Long userId, String type,
            String year) {
        return this.respository.getTransactionBarIncomeExpenseByUserIdAndType(userId, type, year);
    }

    @Override
    public TransactionFindOneDTO findOne(Long id) {
        Optional<TransactionEntity> transactionOpt = this.respository.findById(id);
        if (!transactionOpt.isPresent()) {
            throw new ObjectNotFoundException("Transaction not found");
        }
        TransactionEntity transaction = transactionOpt.get();
        UserFindOneDTO userDTO = this.userService.findOne(transaction.getUser().getId());
        CategoryFindOneDTO categoryDTO = this.categoryService.findOne(transaction.getCategory().getId());
        BankAccountFindOne bankAccountOrigin = this.bankAccountService
                .findOne(transaction.getBankAccountOrigin().getId());
        BankAccountFindOne bankAccountDestination = null;
        if (transaction.getBankAccountDestination() != null) {
            bankAccountDestination = this.bankAccountService
                    .findOne(transaction.getBankAccountDestination().getId());
        }
        TransactionFindOneDTO dto = TransactionFindOneDTO.builder()
                .id(id)
                .user(userDTO)
                .category(categoryDTO)
                .bankAccountOrigin(bankAccountOrigin)
                .bankAccountDestination(bankAccountDestination)
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .build();
        return dto;
    }

    @Override
    public String update(TransactionUpdateDTO transaction) {
        Optional<TransactionEntity> transactionOpt = this.respository.findById(transaction.getId());
        if (transactionOpt.isEmpty()) {
            throw new ObjectNotFoundException("Transaction not found");
        }
        TransactionEntity transactionEntity = transactionOpt.get();
        transactionEntity.setDate(transaction.getDate());
        transactionEntity.setCategory(transaction.getCategory());
        transactionEntity.setBankAccountOrigin(transaction.getBankAccountOrigin());
        transactionEntity.setBankAccountDestination(transaction.getBankAccountDestination());
        transactionEntity.setDescription(transaction.getDescription());
        transactionEntity.setAmount(transaction.getAmount());
        respository.save(transactionEntity);
        return "Successfully updated";
    }
}
