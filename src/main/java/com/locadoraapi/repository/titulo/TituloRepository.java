package com.locadoraapi.repository.titulo;


import com.locadoraapi.domain.Titulo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TituloRepository {

    List<Titulo> findAll();

    Optional<Titulo> findById(UUID id);

    Optional<Titulo> findByNome(String nome);

    void save(Titulo titulo);

    void update(Titulo titulo);

    void deleteById(UUID tituloId);
}
