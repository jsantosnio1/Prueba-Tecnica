package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entity.Museos;
import com.example.pruebatecnica.repository.MuseosRepository;
import com.example.pruebatecnica.service.api.MuseosServiceAPI;
import com.example.pruebatecnica.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MuseosServiceImpl extends GenericServiceImpl<Museos,Integer> implements MuseosServiceAPI {

    @Autowired
    private MuseosRepository museosDaoAPI;

    @Override
    public CrudRepository<Museos,Integer> getDao(){
        return museosDaoAPI;
    }
}
