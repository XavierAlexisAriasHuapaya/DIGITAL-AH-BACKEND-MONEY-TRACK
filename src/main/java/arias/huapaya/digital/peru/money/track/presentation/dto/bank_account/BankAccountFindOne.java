package arias.huapaya.digital.peru.money.track.presentation.dto.bank_account;

import arias.huapaya.digital.peru.money.track.persistence.enums.TypeAccountEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountFindOne {

    private Long id;

    private String name;

    private TypeAccountEnum typeAccount;

    private Boolean enabled;

}
