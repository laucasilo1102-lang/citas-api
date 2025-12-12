package com.gestion.citas_api.repository;

import com.gestion.citas_api.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {
}
