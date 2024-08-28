package com.northcoders.demospringbootapp.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
public class GenericDAO {
    public static <T> String getJsonResponse(String url, String[] args, String[] headerVars) {
        WebClient.Builder clientBuilder = WebClient.builder()
                .baseUrl(url);

        for(String header: headerVars) {
            if (!header.contains("="))
                continue;

            String[] splitHeader = header.split("=");
            clientBuilder.defaultHeader(splitHeader[0], splitHeader[1]);
        }

        WebClient client = clientBuilder.build();

        StringBuilder uriArgs = new StringBuilder();
        StringBuilder headerArgs = new StringBuilder();

        uriArgs.append("?");

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            uriArgs.append(arg);

            if (i != args.length)
                uriArgs.append("&");
        }

        String response = client.get()
                .uri(uriArgs.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }

    public static <T> T mapJsonToPojo(String json, Class<T> responseClass) {
        T responseObject = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            responseObject = mapper.readValue(json, responseClass);
        } catch (JsonProcessingException e) {
            System.out.println("Error deserialising JSON to " + responseClass.getClasses().toString());
        }

        return responseObject;
    }

}

