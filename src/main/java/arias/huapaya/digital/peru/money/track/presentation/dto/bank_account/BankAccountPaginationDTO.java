package arias.huapaya.digital.peru.money.track.presentation.dto.bank_account;

import java.time.LocalDateTime;

import arias.huapaya.digital.peru.money.track.persistence.entity.BankAccountEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.TypeAccountEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BankAccountPaginationDTO {

    private Long id;

    private TypeAccountEnum typeAccount;

    private String name;

    private LocalDateTime createdAt;

    private Boolean enabled;

    public BankAccountPaginationDTO(BankAccountEntity bankAccountEntity) {
        this.id = bankAccountEntity.getId();
        this.typeAccount = bankAccountEntity.getTypeAccount();
        this.name = bankAccountEntity.getName();
        this.createdAt = bankAccountEntity.getCreatedAt();
        this.enabled = bankAccountEntity.getEnabled();
    }
}
