package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Aluguel {
    private UUID id;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private double valorTotal;
    private UUID tituloId;

    public Aluguel(String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, double valorTotal, UUID tituloId) {
        this.id = UUID.randomUUID();
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.tituloId = tituloId;
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

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public UUID getTituloId() {
        return tituloId;
    }

    public void setTitulo(UUID tituloId) {
        this.tituloId = tituloId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
