package com.northcoders.demospringbootapp.controller;


import com.northcoders.demospringbootapp.dao.GenericDAO;
import com.northcoders.demospringbootapp.model.CityResponseModel;
import com.northcoders.demospringbootapp.model.PersonModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class DemoController {
    @GetMapping("/hello")
    public String getGreetings() {
        return "Hello there!";
    }


    PersonModel personModel = new PersonModel("Emma", 18, "emma18@gmail.com", "England", "Roast dinner");

    @GetMapping("/helloEmma")
    public PersonModel greeterEmma() {
        return personModel;
    }

    @GetMapping("/city")
    public CityResponseModel getCities(@RequestParam String city, int count) {
        String[] params = new String[]{
                "name=" + city,
                "count="+ count
        };
        String cityResponse = GenericDAO.getJsonResponse("https://geocoding-api.open-meteo.com/v1/search",
                params,
                new String[]{});
        CityResponseModel cities = GenericDAO.mapJsonToPojo(cityResponse, CityResponseModel.class);

         return cities;
    }

    @GetMapping("/coordinates")
    public Map<String, Object> getFirstCityCoordinates(@RequestParam String city){
        Map<String, Object> coordinatesMap = new HashMap<>();
        CityResponseModel cities = getCities(city, 1);
        coordinatesMap.put("Longitude", cities.results().get(0).longitude());
        coordinatesMap.put("Latitude", cities.results().get(0).latitude());
        return coordinatesMap;
    }
}