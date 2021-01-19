package com.ch.test;

import com.ch.domain.City;
import com.ch.service.CityService;
import org.junit.Test;

import java.util.List;

public class CityServiceTest {
    @Test
    public void test1() {
        CityService cityService = new CityService();
        List<City> citys = cityService.findAllCity();
        System.out.println(citys);
    }
}
