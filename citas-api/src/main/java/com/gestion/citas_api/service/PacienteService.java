package com.gestion.citas_api.service;

import com.gestion.citas_api.entity.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente crear(Paciente p);
    Paciente obtener(Long id);
    List<Paciente> listar();
    Paciente actualizar(Long id, Paciente p);
    void eliminar(Long id);
}