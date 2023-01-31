package com.example.pruebatecnica.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="obras")
public class Obras implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_obras;

    @Column(name="nombre")
    private String nombre;

    @Column(name="pais")
    private String pais;

    //bi-directional many-to-one association to Departamento
    @ManyToOne(targetEntity = Artistas.class)
    @JoinColumn(name="id_artista")
    private Artistas artistas;

    public Obras(){

    }

    public Integer getId_obras() {
        return id_obras;
    }

    public void setId_obras(Integer id_obras) {
        this.id_obras = id_obras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Artistas getArtistas() {
        return artistas;
    }

    public void setArtistas(Artistas artistas) {
        this.artistas = artistas;
    }
}
