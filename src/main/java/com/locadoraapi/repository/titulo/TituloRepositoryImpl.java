package com.locadoraapi.repository.titulo;

import com.locadoraapi.domain.Filme;
import com.locadoraapi.domain.Titulo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TituloRepositoryImpl implements TituloRepository {

    private final JdbcTemplate jdbcTemplate;

    public TituloRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Titulo> findAll() {
        String sql = "SELECT * FROM titulo";
        return jdbcTemplate.query(sql, new TituloRowMapper());
    }

    @Override
    public Optional<Titulo> findById(UUID id) {
        String sql = "SELECT * FROM titulo WHERE id = ?";
        return jdbcTemplate.query(sql, new TituloRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Titulo> findByNome(String nome) {
        String sql = "SELECT * FROM titulo WHERE nome = ?";
        return jdbcTemplate.query(sql, new TituloRowMapper(), nome)
                .stream()
                .findFirst();
    }

    @Override
    public void save(Titulo titulo) {
        String sql = "INSERT INTO titulo(id, nome, diretor, ano_de_lancamento, valor_diaria, tipo, disponivel) " +
                "VALUES(?,?,?,?,?,?, ?)";

        jdbcTemplate.update(sql,
                titulo.getId(),
                titulo.getNome(),
                titulo.getDiretor(),
                titulo.getAnoDeLancamento(),
                titulo.getValorDiaria(),
                titulo instanceof Filme ? "FILME" :  "SERIE",
                titulo.isDisponivel()
        );
    }

    @Override
    public void update(Titulo titulo) {
        String sql = "UPDATE titulo SET nome = ?, diretor = ?, ano_de_lancamento = ?, valor_diaria = ?, tipo = ?, aluguel_id = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                titulo.getNome(),
                titulo.getDiretor(),
                titulo.getAnoDeLancamento(),
                titulo.getValorDiaria(),
                titulo instanceof Filme ? "FILME" :  "SERIE",
                titulo.getAluguelId(),
                titulo.getId()
        );
    }

    @Override
    public void deleteById(UUID tituloId) {
        String sql = "DELETE FROM titulo WHERE id = ?";
        jdbcTemplate.update(sql, tituloId);
    }
}
