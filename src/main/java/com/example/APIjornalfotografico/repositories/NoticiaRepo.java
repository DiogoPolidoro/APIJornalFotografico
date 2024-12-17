package com.example.APIjornalfotografico.repositories;

import com.example.APIjornalfotografico.models.Noticias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepo extends JpaRepository<Noticias, Long> {

}