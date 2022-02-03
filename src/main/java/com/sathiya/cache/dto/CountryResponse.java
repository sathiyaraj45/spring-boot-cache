package com.sathiya.cache.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Sathiyaraj created on 02-02-2022
 * <p>
 * TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {
    @JsonIgnore
    private long id;
    private String countryCode;
    private String countryName;
}
