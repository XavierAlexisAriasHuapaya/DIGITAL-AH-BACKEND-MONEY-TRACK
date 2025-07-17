package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import java.time.LocalDate;

import arias.huapaya.digital.peru.money.track.persistence.entity.BankAccountEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.CategoryEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionCreateDTO {

    private UserEntity user;

    private CategoryEntity category;

    private BankAccountEntity bankAccountOrigin;

    private BankAccountEntity bankAccountDestination;

    private String description;

    private Double amount;

    private LocalDate date;
    
}
