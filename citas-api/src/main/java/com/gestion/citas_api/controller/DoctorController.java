package com.gestion.citas_api.controller;

import com.gestion.citas_api.dto.DoctorDTO;
import com.gestion.citas_api.entity.Doctor;
import com.gestion.citas_api.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public Doctor crear(@RequestBody DoctorDTO dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<Doctor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Doctor obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Doctor actualizar(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
