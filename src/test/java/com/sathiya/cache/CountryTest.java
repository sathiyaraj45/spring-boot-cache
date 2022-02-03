package com.sathiya.cache;

import com.sathiya.cache.dto.CountryRequest;
import com.sathiya.cache.dto.CountryResponse;
import com.sathiya.cache.entity.Country;
import com.sathiya.cache.repository.CountryRepository;
import com.sathiya.cache.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */
@SpringBootTest
public class CountryTest {

    @MockBean
    private CountryRepository countryRepo;

    @Autowired
    private CountryService countryServ;

    private List<Country> countryList;
    private CountryRequest countryRequest;
    public Country country;

    @BeforeEach
    public void setData() {
        countryList = new ArrayList<>(List.of(new Country(1, "C100", "India"),
                new Country(2, "C101", "Sri lankha")));
        country = new Country(1, "C100", "India");
        countryRequest = new CountryRequest(1, "C100", "India");
    }

    @Test
    public void addCountryTest() {
        when(countryRepo.save(country)).thenReturn(country);
        CountryResponse countryResponse = countryServ.saveCountry(country);
        assertThat(countryResponse.getCountryName()).isEqualTo(country.getCountryName());
    }

    @Test
    public void getCountryListTest() {
        when(countryRepo.findAll()).thenReturn(countryList);
        List<CountryResponse> list = countryServ.findAllCountry();
        assertThat(countryList.size()).isEqualTo(2);
    }
}
