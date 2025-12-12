package com.gestion.citas_api.service.impl;

import com.gestion.citas_api.entity.Paciente;
import com.gestion.citas_api.exception.ResourceNotFoundException;
import com.gestion.citas_api.repository.PacienteRepository;
import com.gestion.citas_api.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository repository;

    public PacienteServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Paciente crear(Paciente p) {
        return repository.save(p);
    }

    @Override
    public Paciente obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
    }

    @Override
    public List<Paciente> listar() {
        return repository.findAll();
    }

    @Override
    public Paciente actualizar(Long id, Paciente p) {
        Paciente actual = obtener(id);

        actual.setNombre(p.getNombre());
        actual.setDocumento(p.getDocumento());
        actual.setTelefono(p.getTelefono());
        actual.setCorreo(p.getCorreo());
        actual.setDireccion(p.getDireccion());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
