package arias.huapaya.digital.peru.money.track.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import arias.huapaya.digital.peru.money.track.interfaces.BankAccountImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.BankAccountEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.BankAccountRepository;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindOne;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountUpdateDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BankAccountService implements BankAccountImpl {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public String create(BankAccountCreateDTO bankAccount) {
        BankAccountEntity bankAccountCreate = BankAccountEntity.builder()
                .user(bankAccount.getUser())
                .name(bankAccount.getName())
                .typeAccount(bankAccount.getTypeAccount())
                .build();
        this.bankAccountRepository.save(bankAccountCreate);
        return "Successfully created";
    }

    @Override
    public String update(BankAccountUpdateDTO bankAccount) {
        Optional<BankAccountEntity> bankAccountOpt = this.bankAccountRepository.findById(bankAccount.getId());
        if (!bankAccountOpt.isPresent()) {
            return "Bank Account not found";
        }
        BankAccountEntity bankAccountUpdate = BankAccountEntity.builder()
                .id(bankAccount.getId())
                .user(bankAccountOpt.get().getUser())
                .name(bankAccount.getName())
                .typeAccount(bankAccount.getTypeAccount())
                .enabled(bankAccountOpt.get().getEnabled())
                .build();
        this.bankAccountRepository.save(bankAccountUpdate);
        return "Successfully updated";
    }

    @Override
    public List<BankAccountFindAllDTO> findAll(Long userId) {
        List<BankAccountEntity> bankAccounts = this.bankAccountRepository.findAllByUserId(userId);
        List<BankAccountFindAllDTO> listBankAccountFindAllDTOs = new ArrayList<>();
        bankAccounts.forEach(bankAccount -> {
            BankAccountFindAllDTO categoryFindAllDTO = BankAccountFindAllDTO.builder()
                    .id(bankAccount.getId())
                    .name(bankAccount.getName())
                    .typeAccount(bankAccount.getTypeAccount())
                    .enabled(bankAccount.getEnabled())
                    .build();
            listBankAccountFindAllDTOs.add(categoryFindAllDTO);
        });
        return listBankAccountFindAllDTOs;
    }

    @Override
    public PageDTO<BankAccountPaginationDTO> pagination(Long userId, String search,
            Pageable pageable) {
        Page<BankAccountEntity> bankAccountPage = this.bankAccountRepository
                .findByUserIdAndNameContainingIgnoreCase(userId, search, pageable);
        List<BankAccountPaginationDTO> categoriesList = bankAccountPage.getContent()
                .stream()
                .map(bankAccount -> new BankAccountPaginationDTO(bankAccount))
                .toList();
        return new PageDTO<>(categoriesList, bankAccountPage.getNumber(), bankAccountPage.getSize(),
                bankAccountPage.getTotalElements());
    }

    @Override
    public BankAccountFindOne findOne(Long id) {
        Optional<BankAccountEntity> bankAccountOpt = this.bankAccountRepository.findById(id);
        if (!bankAccountOpt.isPresent()) {

        }
        BankAccountFindOne dto = BankAccountFindOne.builder()
                .id(id)
                .name(bankAccountOpt.get().getName())
                .typeAccount(bankAccountOpt.get().getTypeAccount())
                .enabled(bankAccountOpt.get().getEnabled())
                .build();
        return dto;
    }

}
