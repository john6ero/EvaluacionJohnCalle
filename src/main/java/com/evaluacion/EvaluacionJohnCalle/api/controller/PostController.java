package com.evaluacion.EvaluacionJohnCalle.api.controller;

import com.evaluacion.EvaluacionJohnCalle.api.service.PostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostsService postService;

    public PostController(PostsService postService) {
        this.postService = postService;
    }

    @PostMapping("/importar")
    public String importarPosts() {
        postService.GuardarDatosDesdeApi();
        return "Posts importados correctamente";
    }

    @GetMapping("/titles/{userId}")
    public List<String> obtenerTitles(@PathVariable Long userId) {
        return postService.ObtenerTitulosPorId(userId);
    }
}
