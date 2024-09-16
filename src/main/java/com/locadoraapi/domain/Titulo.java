package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Titulo {
    private UUID id;
    private String nome;
    private String diretor;
    private LocalDate anoDeLancamento;
    private double valorDiaria;


    public Titulo(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.diretor = diretor;
        this.anoDeLancamento = anoDeLancamento;
        this.valorDiaria = valorDiaria;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}

