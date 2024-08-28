package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationModel (String date,
                             String sunrise,
                             String sunset,
                             String first_light,
                             String last_light,
                             String dawn,
                             String dusk,
                             String solar_noon,
                             String golden_hour,
                             String day_length,
                             String timezone,
                             int utc_offset){

}
