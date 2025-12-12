package com.gestion.citas_api.dto;

public class EspecialidadDTO {

    private String idEspecialidad;
    private String nombre;
    private String descripcion;

    public EspecialidadDTO() {}

    public String getIdEspecialidad() { return idEspecialidad; }
    public void setIdEspecialidad(String idEspecialidad) { this.idEspecialidad = idEspecialidad; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}

