package com.junitDemo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryServiceTest {

    @Test
    @Tag("smoke")
    void testCountryListNotEmpty() {
        assertTrue(true);
    }

    @Test
    @Tag("slow")
    void testSlowFunctionality() {
        assertTrue(true);
    }
}


