package com.gestion.citas_api.service;

import com.gestion.citas_api.dto.CitaMedicaDTO;
import com.gestion.citas_api.entity.CitaMedica;

import java.util.List;

public interface CitaMedicaService {

    CitaMedica crear(CitaMedicaDTO dto);

    CitaMedica obtener(String id);

    List<CitaMedica> listar();

    List<CitaMedica> citasPorPaciente(Long idPaciente);

    List<CitaMedica> citasPorDoctor(Long idDoctor);

    CitaMedica actualizar(String id, CitaMedicaDTO dto);

    void eliminar(String id);
}

