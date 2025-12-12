package com.gestion.citas_api.dto;

public class DoctorDTO {

    private Long idDoctor;
    private String nombre;
    private String tarjetaProfesional;
    private String telefono;
    private String correo;
    private String idEspecialidad;

    public DoctorDTO() {}

    public Long getIdDoctor() { return idDoctor; }
    public void setIdDoctor(Long idDoctor) { this.idDoctor = idDoctor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTarjetaProfesional() { return tarjetaProfesional; }
    public void setTarjetaProfesional(String tarjetaProfesional) { this.tarjetaProfesional = tarjetaProfesional; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getIdEspecialidad() { return idEspecialidad; }
    public void setIdEspecialidad(String idEspecialidad) { this.idEspecialidad = idEspecialidad; }
}
