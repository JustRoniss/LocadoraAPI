package com.locadoraapi.controller;

import com.locadoraapi.domain.Titulo;
import com.locadoraapi.service.TituloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/titulo")
public class TituloController {

    private final TituloService locadoraService;

    public TituloController(TituloService locadoraService) {
        this.locadoraService = locadoraService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Titulo>> getAllTitulos() {
        return locadoraService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Titulo> createTitulo(@RequestBody Titulo titulo){
        return locadoraService.create(titulo);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Titulo> deleteTitulo(@RequestParam UUID tituloId){
        return locadoraService.delete(tituloId);
    }

//    @PostMapping
//    public ResponseEntity<>


}
