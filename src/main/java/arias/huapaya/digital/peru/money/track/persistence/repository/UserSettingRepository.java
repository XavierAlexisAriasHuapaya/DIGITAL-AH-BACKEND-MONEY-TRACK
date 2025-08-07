package arias.huapaya.digital.peru.money.track.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arias.huapaya.digital.peru.money.track.persistence.entity.UserSettingEntity;

@Repository
public interface UserSettingRepository extends JpaRepository<UserSettingEntity, Long> {

    public UserSettingEntity findByUserId(Long userId);

}
