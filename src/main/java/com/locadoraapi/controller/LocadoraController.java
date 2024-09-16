package com.locadoraapi.controller;

import com.locadoraapi.service.LocadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {
    private final LocadoraService locadoraService;

    public LocadoraController(LocadoraService locadoraService) {
        this.locadoraService = locadoraService;
    }

//    @GetMapping("/filmes/get/all")
//    public ResponseEntity getAllFilmes(){
//
//        return ResponseEntity.ok();
//    }

}
