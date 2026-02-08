package com.evaluacion.EvaluacionJohnCalle.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.evaluacion.EvaluacionJohnCalle.api.model.Posts;
import com.evaluacion.EvaluacionJohnCalle.api.repository.PostsRepository;

@ExtendWith(MockitoExtension.class)
class PostsServiceTest {

    @Mock
    private PostsRepository postRepository;

    @InjectMocks
    private PostsService postsService;

    @Test
    void obtenerTitulosPorId_devuelveListaCorrecta() {

        List<Posts> mockPosts = List.of(
                new Posts(1L, 1L, "Titulo1", "Body1"),
                new Posts(2L, 1L, "Titulo2", "Body2")
        );

        when(postRepository.findByUserId(1L)).thenReturn(mockPosts);

        List<String> titulos = postsService.ObtenerTitulosPorId(1L);

        assertEquals(2, titulos.size(), "Debe devolver dos títulos");
        assertTrue(titulos.contains("Titulo1"), "Debe contener Titulo1");
        assertTrue(titulos.contains("Titulo2"), "Debe contener Titulo2");

        verify(postRepository, times(1)).findByUserId(1L);
    }

    @Test
    void obtenerTitulosPorId_devuelveListaVaciaSiNoHayPosts() {
        when(postRepository.findByUserId(1L)).thenReturn(List.of());

        List<String> titulos = postsService.ObtenerTitulosPorId(1L);

        assertTrue(titulos.isEmpty(), "Debe devolver lista vacía si no hay posts");
        verify(postRepository, times(1)).findByUserId(1L);
    }
}