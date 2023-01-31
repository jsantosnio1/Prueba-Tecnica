package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entity.Artistas;
import com.example.pruebatecnica.repository.ArtistasRepository;
import com.example.pruebatecnica.service.api.ArtistasServiceAPI;
import com.example.pruebatecnica.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistasServiceImpl extends GenericServiceImpl<Artistas,Integer> implements ArtistasServiceAPI {

    @Autowired
    private ArtistasRepository aritistasDaoAPI;

    @Override
    public CrudRepository<Artistas,Integer> getDao(){
        return aritistasDaoAPI;
    }
}
