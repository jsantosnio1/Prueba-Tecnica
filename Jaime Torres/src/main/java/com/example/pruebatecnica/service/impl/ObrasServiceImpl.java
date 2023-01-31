package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.entity.Obras;
import com.example.pruebatecnica.repository.ObrasRespository;
import com.example.pruebatecnica.service.api.ObrasServiceAPI;
import com.example.pruebatecnica.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ObrasServiceImpl extends GenericServiceImpl<Obras,Integer> implements ObrasServiceAPI {

    @Autowired
    private ObrasRespository obrasDaoAPI;

    @Override
    public CrudRepository<Obras, Integer> getDao() {
        return obrasDaoAPI;
    }
}
