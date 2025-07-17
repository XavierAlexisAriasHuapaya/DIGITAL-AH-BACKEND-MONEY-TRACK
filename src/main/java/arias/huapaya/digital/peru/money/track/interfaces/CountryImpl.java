package arias.huapaya.digital.peru.money.track.interfaces;

import java.util.List;

import arias.huapaya.digital.peru.money.track.persistence.entity.CountryEntity;

public interface CountryImpl {

    List<CountryEntity> findAll();

    CountryEntity findById(Long id);
}
