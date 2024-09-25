package com.locadoraapi.service;


import com.locadoraapi.domain.Titulo;
import com.locadoraapi.repository.titulo.TituloRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TituloService {

    // Aqui estamos apontando diretamente pra interface - LISKOV PRINCIPLE
    private final TituloRepository tituloRepository;

    public TituloService(TituloRepository tituloRepository) {
        this.tituloRepository = tituloRepository;
    }

    public ResponseEntity<List<Titulo>> getAll() {
        List<Titulo> titulos = tituloRepository.findAll();
        return ResponseEntity.ok(titulos);
    }

    public ResponseEntity<Titulo> create(Titulo titulo) {
        try{
            titulo.setId(UUID.randomUUID());
            titulo.setDisponivel(true);
            tituloRepository.save(titulo);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Titulo> delete(UUID tituloId) {
        try{
            tituloRepository.deleteById(tituloId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
