package com.locadoraapi.repository.aluguel;

import com.locadoraapi.domain.Aluguel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AluguelRepository {
    List<Aluguel> findAll();
    Optional<Aluguel> findById(Long id);
    Optional<Aluguel> findByClienteNome(String clienteNome);
    void save(Aluguel aluguel);
    void update(Aluguel aluguel);
    void deleteById(UUID id);
}
