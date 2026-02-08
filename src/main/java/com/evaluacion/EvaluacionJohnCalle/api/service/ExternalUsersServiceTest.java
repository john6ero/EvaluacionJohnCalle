package com.evaluacion.EvaluacionJohnCalle.api.service;

import com.evaluacion.EvaluacionJohnCalle.api.model.ExternalUser;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExternalUserServiceTest {

    @Test
    void obtenerTodosUsuarios_devuelveListaUsuarios() {

        RestTemplate restTemplateMock = mock(RestTemplate.class);

        ExternalUser u1 = new ExternalUser();
        u1.setId(1L);
        u1.setName("Leanne Graham");

        ExternalUser u2 = new ExternalUser();
        u2.setId(2L);
        u2.setName("Ervin Howell");

        ExternalUser[] mockResponse = {u1, u2};

        when(restTemplateMock.getForObject(anyString(), eq(ExternalUser[].class)))
                .thenReturn(mockResponse);

        ExternalUserService service = new ExternalUserService() {
            @Override
            public List<ExternalUser> obtenerTodosUsuarios() {
                ExternalUser[] usuarios = restTemplateMock.getForObject("", ExternalUser[].class);
                return List.of(usuarios);
            }
        };

        List<ExternalUser> usuarios = service.obtenerTodosUsuarios();

        assertEquals(2, usuarios.size());
        assertEquals("Leanne Graham", usuarios.get(0).getName());
        assertEquals("Ervin Howell", usuarios.get(1).getName());

        verify(restTemplateMock, times(1)).getForObject(anyString(), eq(ExternalUser[].class));
    }
}