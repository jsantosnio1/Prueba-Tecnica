package com.example.pruebatecnica.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="museos")
public class Museos implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_museo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="pais")
    private String pais;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="direccion")
    private String direccion;




    public Museos(){

    }


    public Integer getId_museo() {
        return id_museo;
    }

    public void setId_museo(Integer id_museo) {
        this.id_museo = id_museo;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
