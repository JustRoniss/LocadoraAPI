package com.locadoraapi.repository.titulo;

import com.locadoraapi.domain.*;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class TituloRowMapper implements RowMapper<Titulo> {

    @Override
    public Titulo mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        UUID id = resultSet.getObject("id", UUID.class);
        String tipo = resultSet.getString("tipo");
        String nome = resultSet.getString("nome");
        String diretor = resultSet.getString("diretor");
        LocalDate anoDeLancamento = resultSet.getObject("ano_de_lancamento", LocalDate.class);
        double valorDiaria = resultSet.getDouble("valor_diaria");
        boolean disponivel = resultSet.getBoolean("disponivel");
        UUID aluguelId  = resultSet.getObject("aluguel_id", UUID.class);

        if(tipo.equals("FILME")){
            return new Filme(id, nome, diretor, anoDeLancamento, valorDiaria, new GestorAluguel(), disponivel, aluguelId);
        }else if(tipo.equals("SERIE")){
            return new Serie(id, nome, diretor, anoDeLancamento, valorDiaria, new GestorAluguel(), disponivel, aluguelId);
        }else {
            throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
    }
}
