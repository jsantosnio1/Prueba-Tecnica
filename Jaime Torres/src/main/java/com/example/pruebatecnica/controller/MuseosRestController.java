package com.example.pruebatecnica.controller;


import com.example.pruebatecnica.entity.Museos;
import com.example.pruebatecnica.service.api.MuseosServiceAPI;
import com.example.pruebatecnica.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/museos")
public class MuseosRestController {

    @Autowired
    private MuseosServiceAPI museosServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Museos> getAll() {
        return museosServiceAPI.getAll();
    }

    @PostMapping(value = "/saveMuseos")
    public ResponseEntity<Museos> save(@RequestBody Museos museos) {
        Museos obj = museosServiceAPI.save(museos);
        return new ResponseEntity<Museos>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Museos> getMuseosById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Museos museos = museosServiceAPI.get(id);
        if (museos == null) {
            new ResourceNotFoundException("Record not found for <Museos>" + id);
        }
        return ResponseEntity.ok().body(museos);
    }



    @DeleteMapping(value = "/deleteMuseos/{id}")
    public ResponseEntity<Museos> delete(@PathVariable Integer id) {
        Museos museos = museosServiceAPI.get(id);
        if (museos != null) {
            museosServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Museos>(museos, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Museos>(museos, HttpStatus.OK);
    }
}
