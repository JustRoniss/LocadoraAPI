package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Aluguel {
    private UUID id;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private double valorTotal;


    public Aluguel(String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, double valorTotal) {
        this.id = UUID.randomUUID();
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
    }

    public UUID getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
