package com.gestion.citas_api.service.impl;

import com.gestion.citas_api.entity.Especialidad;
import com.gestion.citas_api.exception.ResourceNotFoundException;
import com.gestion.citas_api.repository.EspecialidadRepository;
import com.gestion.citas_api.service.EspecialidadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository repository;

    public EspecialidadServiceImpl(EspecialidadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Especialidad crear(Especialidad especialidad) {
        return repository.save(especialidad);
    }

    @Override
    public List<Especialidad> listar(int limit) {
        List<Especialidad> todas = repository.findAll();
        return todas.stream().limit(limit).toList();
    }

    @Override
    public Especialidad obtenerPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada: " + id));
    }

    @Override
    public Especialidad actualizar(String id, Especialidad especialidad) {
        Especialidad existente = obtenerPorId(id);

        existente.setNombre(especialidad.getNombre());
        existente.setDescripcion(especialidad.getDescripcion());

        return repository.save(existente);
    }

    @Override
    public void eliminar(String id) {
        Especialidad esp = obtenerPorId(id);
        repository.delete(esp);
    }
}

