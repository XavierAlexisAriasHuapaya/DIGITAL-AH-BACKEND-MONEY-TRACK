package arias.huapaya.digital.peru.money.track.presentation.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionBarDTO {

    private String month_num;

    private String month;

    private Double income;

    private Double expense;

    private String backgroundColorIncome;

    private String borderColorIncome;

    private String backgroundColorExpense;

    private String borderColorExpense;
    
}
