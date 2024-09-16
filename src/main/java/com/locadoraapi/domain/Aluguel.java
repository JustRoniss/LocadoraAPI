package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Aluguel {
    private UUID id;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private double valorTotal;
    private Titulo titulo;
    private boolean ativo;

    public Aluguel(String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao, double valorTotal, Titulo titulo, boolean ativo) {
        this.id = UUID.randomUUID();
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.titulo = titulo;
        this.ativo = ativo;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
