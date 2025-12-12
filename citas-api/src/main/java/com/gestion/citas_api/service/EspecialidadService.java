package com.gestion.citas_api.service;

import com.gestion.citas_api.entity.Especialidad;

import java.util.List;

public interface EspecialidadService {

    Especialidad crear(Especialidad especialidad);

    List<Especialidad> listar(int limit);

    Especialidad obtenerPorId(String id);

    Especialidad actualizar(String id, Especialidad especialidad);

    void eliminar(String id);
}
