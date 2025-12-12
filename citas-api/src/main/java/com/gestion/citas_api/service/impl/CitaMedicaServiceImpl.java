package com.gestion.citas_api.service.impl;

import com.gestion.citas_api.dto.CitaMedicaDTO;
import com.gestion.citas_api.entity.CitaMedica;
import com.gestion.citas_api.entity.Doctor;
import com.gestion.citas_api.entity.Paciente;
import com.gestion.citas_api.exception.ResourceNotFoundException;
import com.gestion.citas_api.repository.CitaMedicaRepository;
import com.gestion.citas_api.repository.DoctorRepository;
import com.gestion.citas_api.repository.PacienteRepository;
import com.gestion.citas_api.service.CitaMedicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository repository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;

    public CitaMedicaServiceImpl(CitaMedicaRepository repository,
                                 PacienteRepository pacienteRepository,
                                 DoctorRepository doctorRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public CitaMedica crear(CitaMedicaDTO dto) {

        Paciente p = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));

        Doctor d = doctorRepository.findById(dto.getIdDoctor())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        CitaMedica c = new CitaMedica();
        c.setIdCita(dto.getIdCita());
        c.setFecha(dto.getFecha());
        c.setHora(dto.getHora());
        c.setMotivo(dto.getMotivo());
        c.setPaciente(p);
        c.setDoctor(d);

        return repository.save(c);
    }

    @Override
    public CitaMedica obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));
    }

    @Override
    public List<CitaMedica> listar() {
        return repository.findAll();
    }

    @Override
    public List<CitaMedica> citasPorPaciente(Long idPaciente) {
        return repository.findByPaciente_IdPaciente(idPaciente);
    }

    @Override
    public List<CitaMedica> citasPorDoctor(Long idDoctor) {
        return repository.findByDoctor_IdDoctor(idDoctor);
    }


    @Override
    public CitaMedica actualizar(String id, CitaMedicaDTO dto) {

        CitaMedica c = obtener(id);

        Paciente p = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));

        Doctor d = doctorRepository.findById(dto.getIdDoctor())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        c.setFecha(dto.getFecha());
        c.setHora(dto.getHora());
        c.setMotivo(dto.getMotivo());
        c.setPaciente(p);
        c.setDoctor(d);

        return repository.save(c);
    }

    @Override
    public void eliminar(String id) {
        CitaMedica c = obtener(id);
        repository.delete(c);
    }
}


