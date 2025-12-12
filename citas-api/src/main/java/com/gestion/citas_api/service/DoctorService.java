package com.gestion.citas_api.service;

import com.gestion.citas_api.dto.DoctorDTO;
import com.gestion.citas_api.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor crear(DoctorDTO dto);

    Doctor obtenerPorId(Long id);

    List<Doctor> listar();

    Doctor actualizar(Long id, DoctorDTO dto);

    void eliminar(Long id);
}