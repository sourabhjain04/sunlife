package com.junitDemo;

import java.util.Arrays;
import java.util.List;

public class CountryService {
    public List<String> getAllCountries() {
        return Arrays.asList("India", "USA", "Japan");
    }

    public boolean isValidCountry(String country) {
        return getAllCountries().contains(country);
    }
}
