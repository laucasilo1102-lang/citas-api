package com.gestion.citas_api.controller;

import com.gestion.citas_api.dto.CitaMedicaDTO;
import com.gestion.citas_api.entity.CitaMedica;
import com.gestion.citas_api.service.CitaMedicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }


    @PostMapping
    public CitaMedica crear(@RequestBody CitaMedicaDTO dto) {
        return service.crear(dto);
    }


    @GetMapping
    public List<CitaMedica> listar() {
        return service.listar();
    }


    @GetMapping("/{id}")
    public CitaMedica obtener(@PathVariable String id) {
        return service.obtener(id);
    }


    @GetMapping("/paciente/{idPaciente}")
    public List<CitaMedica> citasPorPaciente(@PathVariable Long idPaciente) {
        return service.citasPorPaciente(idPaciente);
    }


    @GetMapping("/doctor/{idDoctor}")
    public List<CitaMedica> citasPorDoctor(@PathVariable Long idDoctor) {
        return service.citasPorDoctor(idDoctor);
    }


    @PutMapping("/{id}")
    public CitaMedica actualizar(@PathVariable String id, @RequestBody CitaMedicaDTO dto) {
        return service.actualizar(id, dto);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}


