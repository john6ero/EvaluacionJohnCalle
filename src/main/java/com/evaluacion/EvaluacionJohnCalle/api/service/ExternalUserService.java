package com.evaluacion.EvaluacionJohnCalle.api.service;

import com.evaluacion.EvaluacionJohnCalle.api.model.ExternalUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalUserService {

    private static final String URL_USERS = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public ExternalUserService() {
        this.restTemplate = new RestTemplate();
    }

    public List<ExternalUser> obtenerTodosUsuarios() {
        ExternalUser[] usuarios = restTemplate.getForObject(URL_USERS, ExternalUser[].class);
        return usuarios != null ? Arrays.asList(usuarios) : List.of();
    }
}