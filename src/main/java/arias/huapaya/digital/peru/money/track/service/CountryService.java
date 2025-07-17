package arias.huapaya.digital.peru.money.track.service;

import java.util.List;

import org.springframework.stereotype.Service;

import arias.huapaya.digital.peru.money.track.interfaces.CountryImpl;
import arias.huapaya.digital.peru.money.track.persistence.entity.CountryEntity;
import arias.huapaya.digital.peru.money.track.persistence.repository.CountryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CountryService implements CountryImpl {

    private final CountryRepository countryRepository;

    @Override
    public List<CountryEntity> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public CountryEntity findById(Long id) {
        return this.countryRepository.findById(id).orElse(null);
    }

}
