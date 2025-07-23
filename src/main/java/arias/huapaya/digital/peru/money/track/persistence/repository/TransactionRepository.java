package arias.huapaya.digital.peru.money.track.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;
import arias.huapaya.digital.peru.money.track.presentation.dto.transaction.TransactionBalanceDTO;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Page<TransactionEntity> findByUserIdAndDescriptionContainingIgnoreCase(Long userId, String search,
            Pageable pageable);

    @Query(value = "SELECT " +
            "COALESCE(SUM(CASE WHEN c.type = 'INBOUND' THEN t.amount END), 0) AS inbound, " +
            "COALESCE(SUM(CASE WHEN c.type = 'OUTBOUND' THEN t.amount END), 0) AS outbound, " +
            "(COALESCE(SUM(CASE WHEN c.type = 'INBOUND' THEN t.amount END), 0) " +
            "- COALESCE(SUM(CASE WHEN c.type = 'OUTBOUND' THEN t.amount END), 0)) AS balance " +
            "FROM transactions t " +
            "INNER JOIN categories c ON c.id = t.category_id  " +
            "WHERE t.user_id = 1 " +
            "AND t.enabled = TRUE", nativeQuery = true)
    TransactionBalanceDTO getBalanceByUserId(Long userId);

}
