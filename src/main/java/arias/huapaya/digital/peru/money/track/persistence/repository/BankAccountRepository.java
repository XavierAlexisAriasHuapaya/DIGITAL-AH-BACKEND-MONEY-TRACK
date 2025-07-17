package arias.huapaya.digital.peru.money.track.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import arias.huapaya.digital.peru.money.track.persistence.entity.BankAccountEntity;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {

    List<BankAccountEntity> findAllByUserId(Long userId);

    Page<BankAccountEntity> findByUserIdAndNameContainingIgnoreCase(Long userId, String search, Pageable pageable);

}
