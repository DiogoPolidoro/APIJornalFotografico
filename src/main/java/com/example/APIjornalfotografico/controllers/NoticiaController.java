package com.example.APIjornalfotografico.controllers;

import com.example.APIjornalfotografico.models.Noticias;
import com.example.APIjornalfotografico.repositories.NoticiaRepo;
import com.example.APIjornalfotografico.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NoticiaController {

    @Autowired
    private NoticiaRepo noticiaRepository;

    @Autowired
    private UserRepo userRepository;

    @GetMapping
    public List<Noticias> getAllNews() {
        return noticiaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Noticias> createNews(@RequestBody Noticias noticia) {
        return userRepository.findById(noticia.getAuthor().getId())
                .map(user -> {
                    noticia.setAuthor(user);
                    return ResponseEntity.ok(noticiaRepository.save(noticia));
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticias> getNewsById(@PathVariable Long id) {
        return noticiaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}