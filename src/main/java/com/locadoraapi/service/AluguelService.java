package com.locadoraapi.service;

import com.locadoraapi.domain.Aluguel;
import com.locadoraapi.domain.Titulo;
import com.locadoraapi.repository.aluguel.AluguelRepository;
import com.locadoraapi.repository.titulo.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final TituloRepository tituloRepository;

    AluguelService(AluguelRepository aluguelRepository, TituloRepository tituloRepository) {
        this.aluguelRepository = aluguelRepository;
        this.tituloRepository = tituloRepository;
    }

    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        return ResponseEntity.ok(alugueis);
    }

    public ResponseEntity<Aluguel> create(Aluguel aluguel) {
        try{
           Optional<Titulo> titulo = tituloRepository.findById(aluguel.getTituloId());
            if(titulo.isPresent()) {
                Titulo tituloEncontrado = titulo.get();
                tituloEncontrado.alugar(aluguel);

                aluguelRepository.save(aluguel);
                tituloRepository.update(tituloEncontrado);

                return ResponseEntity.ok(aluguel);
            }else {
                return ResponseEntity.notFound().build();
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
