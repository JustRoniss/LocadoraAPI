package com.locadoraapi.controller;

import com.locadoraapi.domain.Aluguel;
import com.locadoraapi.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Aluguel>> getAllAlugueis() {
        return aluguelService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Aluguel> createAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.create(aluguel);
    }

}
