package com.evaluacion.EvaluacionJohnCalle.api.controller;

import com.evaluacion.EvaluacionJohnCalle.api.model.ExternalUser;
import com.evaluacion.EvaluacionJohnCalle.api.service.ExternalUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class ExternalUserController {

    private final ExternalUserService externalUserService;

    public ExternalUserController(ExternalUserService externalUserService) {
        this.externalUserService = externalUserService;
    }

    @GetMapping("/users")
    public List<ExternalUser> getExternalUsers() {
        return externalUserService.obtenerTodosUsuarios();
    }
}