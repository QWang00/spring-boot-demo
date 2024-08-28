package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityModel(int id,
                        String name,
                        Float latitude,
                        Float longitude,
                        Float elevation,
                        String feature_code,
                        String country_code,
                        String country,
                        int country_id,
                        int population,
                        ArrayList<String> postcodes,
                        String admin1,
                        String admin2,
                        String admin3,
                        String admin4,
                        int admin1_id,
                        int admin2_id,
                        int admin3_id,
                        int admin4_id,
                        String timezone) {}
