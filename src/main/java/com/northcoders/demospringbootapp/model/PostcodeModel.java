package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostcodeModel(ArrayList<String> postcodes) {
}
