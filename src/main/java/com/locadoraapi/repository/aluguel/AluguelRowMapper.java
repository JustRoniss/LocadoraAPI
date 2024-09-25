package com.locadoraapi.repository.aluguel;

import com.locadoraapi.domain.Aluguel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class AluguelRowMapper implements RowMapper<Aluguel> {
    @Override
    public Aluguel mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        UUID id = resultSet.getObject("id", UUID.class);
        String nomeCliente = resultSet.getString("nome_cliente");
        UUID tituloId  = resultSet.getObject("id_titulo", UUID.class);
        LocalDate dataLocacao = resultSet.getObject("data_locacao", LocalDate.class);
        LocalDate dataDevolucao = resultSet.getObject("data_devolucao", LocalDate.class);
        Double valorTotal = resultSet.getDouble("valor_total");

        return new Aluguel(nomeCliente, dataLocacao, dataDevolucao, valorTotal, tituloId);
    }
}
