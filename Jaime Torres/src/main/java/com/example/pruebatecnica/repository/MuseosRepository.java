package com.example.pruebatecnica.repository;


import com.example.pruebatecnica.entity.Museos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public interface MuseosRepository extends CrudRepository<Museos,Integer> {

    @Query("SELECT * FROM museos WHERE ciudad = 'Cali' AND nombre LIKE 'L%'")
    List<Museos> findUsersWithPartOfName(@Param("username") String username);
}
