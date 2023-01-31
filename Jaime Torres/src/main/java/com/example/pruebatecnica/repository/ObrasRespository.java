package com.example.pruebatecnica.repository;

import com.example.pruebatecnica.entity.Obras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObrasRespository extends CrudRepository<Obras,Integer> {
}
