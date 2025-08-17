package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import java.time.LocalDate;

import arias.huapaya.digital.peru.money.track.presentation.dto.bank_account.BankAccountFindOne;
import arias.huapaya.digital.peru.money.track.presentation.dto.category.CategoryFindOneDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.user.UserFindOneDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionFindOneDTO {
    
    private Long id;

    private UserFindOneDTO user;

    private CategoryFindOneDTO category;

    private BankAccountFindOne bankAccountOrigin;

    private BankAccountFindOne bankAccountDestination;

    private String description;

    private Double amount;

    private LocalDate date;
}
