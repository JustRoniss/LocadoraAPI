package com.locadoraapi.service;


import com.locadoraapi.domain.Titulo;
import com.locadoraapi.repository.TituloRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocadoraService {

    private final TituloRepository tituloRepository;

    public LocadoraService(TituloRepository tituloRepository) {
        this.tituloRepository = tituloRepository;
    }

    public ResponseEntity<List<Titulo>> getAllTitulos() {
        List<Titulo> titulos = tituloRepository.findAll();
        return ResponseEntity.ok(titulos);
    }

    public ResponseEntity<Titulo> createTitulo(Titulo titulo) {
        try{
            titulo.setId(UUID.randomUUID());
            tituloRepository.save(titulo);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Titulo> deleteTitulo(UUID tituloId) {
        try{
            tituloRepository.deleteById(tituloId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
