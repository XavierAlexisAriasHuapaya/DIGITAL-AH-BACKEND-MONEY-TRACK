package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionBalanceDTO {
    
    private Double amount_inbound;

    private Double amount_outbound;

    private Double balance;

}
