package com.gestion.citas_api.controller;

import com.gestion.citas_api.entity.Especialidad;
import com.gestion.citas_api.service.EspecialidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    private final EspecialidadService service;

    public EspecialidadController(EspecialidadService service) {
        this.service = service;
    }

    @PostMapping
    public Especialidad crear(@RequestBody Especialidad e) {
        return service.crear(e);
    }

    @GetMapping
    public List<Especialidad> listar(@RequestParam(defaultValue = "10") int limit) {
        return service.listar(limit);
    }

    @GetMapping("/{id}")
    public Especialidad obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Especialidad actualizar(@PathVariable String id, @RequestBody Especialidad e) {
        return service.actualizar(id, e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
