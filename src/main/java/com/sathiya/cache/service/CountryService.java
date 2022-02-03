package com.sathiya.cache.service;

import com.sathiya.cache.dto.CountryRequest;
import com.sathiya.cache.dto.CountryResponse;
import com.sathiya.cache.entity.Country;
import com.sathiya.cache.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepo;

    @Cacheable("country")
    public List<CountryResponse> findAllCountry() {
        List<CountryResponse> countryRespList;
        List<Country> countryList = countryRepo.findAll();
        countryRespList = countryList.stream().map(countryObj -> {
            CountryResponse rep = new CountryResponse();
            rep.setCountryCode(countryObj.getCountryCode());
            rep.setCountryName(countryObj.getCountryName());
            return rep;
        }).collect(Collectors.toList());
        return countryRespList;
    }

    public CountryResponse saveCountry(Country country) {
        CountryResponse countryResp = new CountryResponse();
        Country savedCountry = countryRepo.save(country);
        countryResp.setCountryName(savedCountry.getCountryName());
        countryResp.setCountryCode(savedCountry.getCountryCode());
        return countryResp;
    }
}
