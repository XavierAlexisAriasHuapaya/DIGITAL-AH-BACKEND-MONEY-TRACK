package arias.huapaya.digital.peru.money.track.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarIncomeExpenseDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionCreateDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionFindAllDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionPaginationDTO;
import arias.huapaya.digital.peru.money.track.util.model.PageDTO;

public interface TransactionImpl {

    String create(TransactionCreateDTO transaction);

    List<TransactionFindAllDTO> findAll();

    PageDTO<TransactionPaginationDTO> pagination(Long userId, String search, Pageable pageable);

    TransactionBalanceDTO getBalanceByUserId(Long userId);

    List<TransactionBarDTO> getTransactionBarByUserId(Long userId, String year);

    List<TransactionBarIncomeExpenseDTO> getTransactionBarIncomeExpenseByUserIdAndType(Long userId, String type, String year);

}
