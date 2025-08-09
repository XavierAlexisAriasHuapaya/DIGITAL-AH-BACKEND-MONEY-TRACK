package arias.huapaya.digital.peru.money.track.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarDTO;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBarIncomeExpenseDTO;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

        Page<TransactionEntity> findByUserIdAndDescriptionContainingIgnoreCase(Long userId, String search,
                        Pageable pageable);

        @Query(value = "SELECT " +
                        "COALESCE(SUM(CASE WHEN c.type = 'INCOME' THEN t.amount END), 0) AS income, " +
                        "COALESCE(SUM(CASE WHEN c.type = 'EXPENSE' THEN t.amount END), 0) AS expense, " +
                        "(COALESCE(SUM(CASE WHEN c.type = 'INCOME' THEN t.amount END), 0) " +
                        "- COALESCE(SUM(CASE WHEN c.type = 'EXPENSE' THEN t.amount END), 0)) AS balance, " +
                        "COALESCE(SUM(CASE when c.type = 'INCOME' AND t.date >= date_trunc('month', current_date) THEN t.amount END), 0) as income_to_month, "
                        +
                        "COALESCE(SUM(CASE when c.type = 'EXPENSE' AND t.date >= date_trunc('month', current_date) THEN t.amount END), 0) as expense_to_month, "
                        +
                        "(COALESCE(SUM(CASE when c.type = 'INCOME' AND t.date >= date_trunc('month', current_date) THEN t.amount END), 0) "
                        +
                        "- COALESCE(SUM(CASE when c.type = 'EXPENSE' AND t.date >= date_trunc('month', current_date) THEN t.amount END), 0)) balance_to_month "
                        +
                        "FROM transactions t " +
                        "INNER JOIN categories c ON c.id = t.category_id  " +
                        "WHERE t.user_id = ?1 " +
                        "AND t.enabled = TRUE", nativeQuery = true)
        TransactionBalanceDTO getBalanceByUserId(Long userId);

        @Query(value = "select " +
                        "to_char(t.date, 'MM') as month_num, " +
                        "to_char(t.date, 'Month') as month, " +
                        "COALESCE(SUM(CASE WHEN c.type = 'INCOME' THEN t.amount END), 0) AS income, " +
                        "COALESCE(SUM(CASE WHEN c.type = 'EXPENSE' THEN t.amount END), 0) AS expense, " +
                        "'rgba(34, 197, 94, 0.70)' as backgroundColorIncome, " +
                        "'rgba(43, 255, 0, 0.2)' as borderColorIncome, " +
                        "'rgba(255, 0, 0, 0.70)' as backgroundColorExpense, " +
                        "'rgba(255, 0, 0, 0.2)' as borderColorExpense " +
                        "from transactions t " +
                        "INNER JOIN categories c ON c.id = t.category_id  " +
                        "WHERE t.user_id = ?1 " +
                        "AND t.enabled = true " +
                        "group by month_num, month " +
                        "order by month_num;", nativeQuery = true)
        List<TransactionBarDTO> getTransactionBarByUserId(Long userId);

        @Query(value = "select " +
                        "c.description, " +
                        "c.type, " +
                        "sum(t.amount)  " +
                        "from transactions t " +
                        "inner join categories c on c.id  = t.category_id " +
                        "where c.user_id = ?1 " +
                        "and c.type = ?2 " +
                        "group by c.description, c.type " +
                        "order by sum(t.amount) desc  " +
                        "limit 5", nativeQuery = true)
        List<TransactionBarIncomeExpenseDTO> getTransactionBarIncomeExpenseByUserIdAndType(Long userId, String type);
}
