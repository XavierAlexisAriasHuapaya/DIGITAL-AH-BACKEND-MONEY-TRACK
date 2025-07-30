package arias.huapaya.digital.peru.money.track.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import arias.huapaya.digital.peru.money.track.persistence.entity.OperationEntity;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    @Query("SELECT o FROM OperationEntity o WHERE o.permitAll = true")
    public List<OperationEntity> findByPublicAccess();

}
