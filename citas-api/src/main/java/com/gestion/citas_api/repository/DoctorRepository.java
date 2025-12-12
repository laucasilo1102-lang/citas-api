package com.gestion.citas_api.repository;

import com.gestion.citas_api.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByEspecialidad_IdEspecialidad(String idEspecialidad);
}
