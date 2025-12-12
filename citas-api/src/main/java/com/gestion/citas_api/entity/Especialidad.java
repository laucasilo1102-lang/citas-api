package com.gestion.citas_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    private String idEspecialidad; // ESP-01

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "especialidad")
    @JsonIgnore
    private List<Doctor> doctores;

    public Especialidad() {}

    public String getIdEspecialidad() { return idEspecialidad; }
    public void setIdEspecialidad(String idEspecialidad) { this.idEspecialidad = idEspecialidad; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Doctor> getDoctores() { return doctores; }
    public void setDoctores(List<Doctor> doctores) { this.doctores = doctores; }
}
