package arias.huapaya.digital.peru.money.track.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arias.huapaya.digital.peru.money.track.persistence.entity.CountryEntity;
import arias.huapaya.digital.peru.money.track.service.CountryService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping(path = "country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CountryEntity> countries = this.countryService.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CountryEntity country = this.countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

}
