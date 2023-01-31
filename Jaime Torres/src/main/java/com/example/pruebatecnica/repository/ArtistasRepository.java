package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.entity.Artistas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistasRepository extends CrudRepository <Artistas,Integer> {

}
