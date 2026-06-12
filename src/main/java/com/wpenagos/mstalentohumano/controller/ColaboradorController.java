package com.wpenagos.mstalentohumano.controller;

import com.wpenagos.mstalentohumano.model.Colaborador;
import com.wpenagos.mstalentohumano.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
//@CrossOrigin(origins = "*")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping
    public Colaborador crearColaborador(@RequestBody Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

    @GetMapping
    public List<Colaborador> listarColaboradores(){
        return colaboradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Colaborador buscarporId(@PathVariable Long id){
        return colaboradorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarcolaborador(@PathVariable long id){
        colaboradorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Colaborador actualizarNombre(@PathVariable Long id, @RequestBody Colaborador datosNuevos) {

        Colaborador colaboradorEnBaseDeDatos = colaboradorRepository.findById(id).orElse(null);

        if (colaboradorEnBaseDeDatos != null) {

            colaboradorEnBaseDeDatos.setDocumentoIdentidad(datosNuevos.getDocumentoIdentidad());
            colaboradorEnBaseDeDatos.setNombres(datosNuevos.getNombres());
            colaboradorEnBaseDeDatos.setApellidos(datosNuevos.getApellidos());
            colaboradorEnBaseDeDatos.setCorreoElectronico(datosNuevos.getCorreoElectronico());
            colaboradorEnBaseDeDatos.setCargo(datosNuevos.getCargo());
            colaboradorEnBaseDeDatos.setFechaIngreso(datosNuevos.getFechaIngreso());
            colaboradorEnBaseDeDatos.setEstadoActivo(datosNuevos.getEstadoActivo());

            return colaboradorRepository.save(colaboradorEnBaseDeDatos);
        }

        return null;
    }
}



