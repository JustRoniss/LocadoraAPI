package com.locadoraapi.repository;


import com.locadoraapi.domain.Titulo;
import java.util.List;
import java.util.Optional;

public interface TituloRepository {

    List<Titulo> findAll();

    Optional<Titulo> findById(Long id);

    Optional<Titulo> findByNome(String nome);

    void save(Titulo titulo);

    void update(Titulo titulo);

    void deleteById(Titulo titulo);
}
