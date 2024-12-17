package com.example.APIjornalfotografico.repositories;

import com.example.APIjornalfotografico.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

}