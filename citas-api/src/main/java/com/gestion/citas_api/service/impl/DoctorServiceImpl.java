package com.gestion.citas_api.service.impl;

import com.gestion.citas_api.dto.DoctorDTO;
import com.gestion.citas_api.entity.Doctor;
import com.gestion.citas_api.entity.Especialidad;
import com.gestion.citas_api.exception.ResourceNotFoundException;
import com.gestion.citas_api.repository.DoctorRepository;
import com.gestion.citas_api.repository.EspecialidadRepository;
import com.gestion.citas_api.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository) {
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public Doctor crear(DoctorDTO dto) {
        Especialidad esp = especialidadRepository.findById(dto.getIdEspecialidad())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada."));

        Doctor d = new Doctor();
        d.setNombre(dto.getNombre());
        d.setTarjetaProfesional(dto.getTarjetaProfesional());
        d.setTelefono(dto.getTelefono());
        d.setCorreo(dto.getCorreo());
        d.setEspecialidad(esp);

        return doctorRepository.save(d);
    }

    @Override
    public Doctor obtenerPorId(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));
    }

    @Override
    public List<Doctor> listar() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor actualizar(Long id, DoctorDTO dto) {
        Doctor d = obtenerPorId(id);

        Especialidad esp = especialidadRepository.findById(dto.getIdEspecialidad())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));

        d.setNombre(dto.getNombre());
        d.setTarjetaProfesional(dto.getTarjetaProfesional());
        d.setTelefono(dto.getTelefono());
        d.setCorreo(dto.getCorreo());
        d.setEspecialidad(esp);

        return doctorRepository.save(d);
    }

    @Override
    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }
}
