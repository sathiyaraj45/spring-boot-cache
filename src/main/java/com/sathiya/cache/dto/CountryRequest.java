package com.sathiya.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    private long id;
    private String countryCode;
    private String countryName;
}
