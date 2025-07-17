package arias.huapaya.digital.peru.money.track.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindOne;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountPaginationDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountUpdateDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;

public interface BankAccountImpl {

    String create(BankAccountCreateDTO bankAccount);

    String update(BankAccountUpdateDTO bankAccount);

    List<BankAccountFindAllDTO> findAll(Long userId);

    PageDTO<BankAccountPaginationDTO> pagination(Long userId, String search,
            Pageable pageable);

    BankAccountFindOne findOne(Long id);

}
