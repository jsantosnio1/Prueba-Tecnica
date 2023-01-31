package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.entity.Obras;
import com.example.pruebatecnica.service.api.ObrasServiceAPI;
import com.example.pruebatecnica.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/obras")
public class ObrasRestController {

    @Autowired
    private ObrasServiceAPI obrasServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Obras> getAll() {
        return obrasServiceAPI.getAll();
    }

    @PostMapping(value = "/saveObras")
    public ResponseEntity<Obras> save(@RequestBody Obras obras) {
        Obras obj = obrasServiceAPI.save(obras);
        return new ResponseEntity<Obras>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Obras> getObrasById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Obras obras = obrasServiceAPI.get(id);
        if (obras == null) {
            new ResourceNotFoundException("Record not found for <Obras>" + id);
        }
        return ResponseEntity.ok().body(obras);
    }

    @DeleteMapping(value = "/deleteObras/{id}")
    public ResponseEntity<Obras> delete(@PathVariable Integer id) {
        Obras obras = obrasServiceAPI.get(id);
        if (obras != null) {
            obrasServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Obras>(obras, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Obras>(obras, HttpStatus.OK);
    }
}
