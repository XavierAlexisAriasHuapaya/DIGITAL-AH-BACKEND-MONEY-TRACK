package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionBarIncomeExpenseDTO {

    private String description;

    private String type;

    private Double amount;
    
}
