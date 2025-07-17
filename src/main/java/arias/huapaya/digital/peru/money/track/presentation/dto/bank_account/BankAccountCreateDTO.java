package arias.huapaya.digital.peru.money.track.presentation.dto.bank_account;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserEntity;
import arias.huapaya.digital.peru.money.track.persistence.enums.TypeAccountEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountCreateDTO {

    private UserEntity user;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypeAccountEnum typeAccount;

}
