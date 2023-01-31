package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.entity.Artistas;
import com.example.pruebatecnica.service.api.ArtistasServiceAPI;
import com.example.pruebatecnica.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/artistas")
public class ArtistasRestController {

    @Autowired
    private ArtistasServiceAPI artistasServiceAPI;

    @GetMapping(value="/getAll")
    public List<Artistas> getAll() {
        return artistasServiceAPI.getAll();
    }

    @PostMapping(value="/saveArtistas")
    public ResponseEntity<Artistas> save(@RequestBody Artistas artistas){
        Artistas obj = artistasServiceAPI.save(artistas);
        return new ResponseEntity<Artistas>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Artistas> getArtistasById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Artistas artistas = artistasServiceAPI.get(id);
        if (artistas == null){
            new  ResourceNotFoundException("Record not found for <Artistas>"+id);
        }
        return ResponseEntity.ok().body(artistas);
    }

    @DeleteMapping(value="/deleteArtistas/{id}")
    public ResponseEntity<Artistas>delete(@PathVariable Integer id){
        Artistas artistas = artistasServiceAPI.get(id);
        if(artistas !=null){
            artistasServiceAPI.delete(id);
        }else {
            return new ResponseEntity<Artistas>(artistas, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Artistas>(artistas,HttpStatus.OK);
    }

}
