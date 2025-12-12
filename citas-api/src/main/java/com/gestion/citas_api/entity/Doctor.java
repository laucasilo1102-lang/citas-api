package com.gestion.citas_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;

    private String nombre;
    private String tarjetaProfesional;
    private String telefono;
    private String correo;


    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad; // ✔ Correcto

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<CitaMedica> citas;

    public Doctor() {}

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

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public List<CitaMedica> getCitas() { return citas; }
    public void setCitas(List<CitaMedica> citas) { this.citas = citas; }
}
