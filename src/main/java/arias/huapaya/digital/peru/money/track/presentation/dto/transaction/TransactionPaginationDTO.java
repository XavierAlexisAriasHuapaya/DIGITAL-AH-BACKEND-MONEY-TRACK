package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

import arias.huapaya.digital.peru.money.track.persistence.entity.BankAccountEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.CategoryEntity;
import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionPaginationDTO {

    private Long id;

    private CategoryEntity category;

    private BankAccountEntity bankAccountOrigin;

    private BankAccountEntity bankAccountDestination;

    private String description;

    private Double amount;

    private LocalDate date;

    private LocalDateTime createdAt;

    private Boolean enabled;

    public TransactionPaginationDTO(TransactionEntity transaction) {
        this.id = transaction.getId();
        this.category = transaction.getCategory();
        this.bankAccountOrigin = transaction.getBankAccountOrigin();
        this.bankAccountDestination = transaction.getBankAccountDestination();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
        this.createdAt = transaction.getCreatedAt();
        this.enabled = transaction.getEnabled();
    }

}
