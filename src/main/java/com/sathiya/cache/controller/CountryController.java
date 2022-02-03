package com.sathiya.cache.controller;

import com.sathiya.cache.dto.CountryRequest;
import com.sathiya.cache.dto.CountryResponse;
import com.sathiya.cache.entity.Country;
import com.sathiya.cache.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */

@RestController
@RequestMapping("api/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryServ;

    @GetMapping("")
    public List<CountryResponse> getAllCountry() {
        return countryServ.findAllCountry();
    }

    @PostMapping("")
    public CountryResponse addCountry(@RequestBody CountryRequest countryRequest) {
        Country country = new Country();
        country.setCountryCode(countryRequest.getCountryCode());
        country.setCountryName(countryRequest.getCountryName());
        return countryServ.saveCountry(country);
    }
}
