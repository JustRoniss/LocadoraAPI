package com.locadoraapi.repository.aluguel;

import com.locadoraapi.domain.Aluguel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AluguelRepositoryImpl implements AluguelRepository{

    private final JdbcTemplate jdbcTemplate;

    public AluguelRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluguel> findAll() {
        String sql = "SELECT * FROM aluguel";
        return jdbcTemplate.query(sql, new AluguelRowMapper());
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        String sql = "SELECT * FROM aluguel WHERE id = ?";
        return jdbcTemplate.query(sql, new AluguelRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Aluguel> findByClienteNome(String clienteNome) {
        String sql = "SELECT * FROM aluguel WHERE cliente_nome = ?";
        return jdbcTemplate.query(sql, new AluguelRowMapper(), clienteNome)
                .stream()
                .findFirst();
    }

    @Override
    public void save(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel (id, nome_cliente, id_titulo, data_locacao, data_devolucao, valor_total) " +
                "VALUES (?, ?, ?, ?, ?, ? )";

        jdbcTemplate.update(sql,
                aluguel.getId(),
                aluguel.getNomeCliente(),
                aluguel.getTituloId(),
                aluguel.getDataEmprestimo(),
                aluguel.getDataDevolucao(),
                aluguel.getValorTotal());

    }

    @Override
    public void update(Aluguel aluguel) {

    }

    @Override
    public void deleteById(UUID id) {
        String sql = "DELETE FROM aluguel WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
