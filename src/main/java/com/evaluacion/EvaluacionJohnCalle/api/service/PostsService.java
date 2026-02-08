package com.evaluacion.EvaluacionJohnCalle.api.service;

import com.evaluacion.EvaluacionJohnCalle.api.model.Posts;
import com.evaluacion.EvaluacionJohnCalle.api.repository.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostsService {

    private final PostsRepository postRepository;
    private final RestTemplate restTemplate;

    public PostsService(PostsRepository postRepository) {
        this.postRepository = postRepository;
        this.restTemplate = new RestTemplate();
    }

    public void GuardarDatosDesdeApi() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Posts[] posts = restTemplate.getForObject(url, Posts[].class);
        if (posts != null) {
            postRepository.saveAll(Arrays.asList(posts));
        }
    }

    public List<String> ObtenerTitulosPorId(Long userId) {
        return postRepository
                .findByUserId(userId)
                .stream()
                .map(Posts::getTitle)
                .toList();
    }
}
