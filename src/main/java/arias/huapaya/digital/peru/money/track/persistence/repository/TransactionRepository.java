package arias.huapaya.digital.peru.money.track.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import arias.huapaya.digital.peru.money.track.persistence.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Page<TransactionEntity> findByUserIdAndDescriptionContainingIgnoreCase(Long userId, String search,
            Pageable pageable);

}
