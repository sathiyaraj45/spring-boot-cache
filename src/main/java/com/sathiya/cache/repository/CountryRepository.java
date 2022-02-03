package com.sathiya.cache.repository;

import com.sathiya.cache.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findById(long id);
    Country findByCountryName(String countryName);
}
