package com.locadoraapi.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GestorAluguel {

    public void alugar(Aluguel aluguel, Titulo titulo) {
        titulo.setAluguel(aluguel.getId());
        aluguel.setTitulo(titulo.getId());
        titulo.setDisponivel(false);
        aluguel.setValorTotal(
                calcularTotal(
                        aluguel.getDataEmprestimo(),
                        aluguel.getDataDevolucao(),
                        titulo.getValorDiaria()
                )
        );
    }

    public void devolver(Aluguel aluguel, Titulo titulo) {
        titulo.setAluguel(null);
        aluguel.setTitulo(null);
        titulo.setDisponivel(true);
    }

    private double calcularTotal(LocalDate dataLocacao, LocalDate dataDevolucao, double valorDiaria) {
        long qtdDias = ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
        return qtdDias * valorDiaria;
    }
}
