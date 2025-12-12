package com.gestion.citas_api.repository;


import com.gestion.citas_api.entity.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, String> {

    List<CitaMedica> findByPaciente_IdPaciente(Long idPaciente);

    List<CitaMedica> findByDoctor_IdDoctor(Long idDoctor);
}
