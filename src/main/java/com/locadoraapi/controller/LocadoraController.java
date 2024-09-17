package com.locadoraapi.controller;

import com.locadoraapi.domain.Titulo;
import com.locadoraapi.service.LocadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {

    private final LocadoraService locadoraService;

    public LocadoraController(LocadoraService locadoraService) {
        this.locadoraService = locadoraService;
    }

    @GetMapping("/titulos/get/all")
    public ResponseEntity<List<Titulo>> getAllFilmes(){
        return locadoraService.getAllTitulos();
    }

    @PostMapping("/titulos/create")
    public ResponseEntity<Titulo> createTitulo(@RequestBody Titulo titulo){
        return locadoraService.createTitulo(titulo);
    }

    @DeleteMapping("/titulos/delete")
    public ResponseEntity<Titulo> deleteTitulo(@RequestParam UUID tituloId){
        return locadoraService.deleteTitulo(tituloId);
    }

}
