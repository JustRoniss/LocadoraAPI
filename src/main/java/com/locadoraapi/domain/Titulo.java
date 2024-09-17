package com.locadoraapi.domain;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.util.UUID;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Filme.class, name = "FILME"),
        @JsonSubTypes.Type(value = Serie.class, name = "SERIE")
})

public abstract class Titulo implements Alugavel{

    private UUID id;
    private String nome;
    private String diretor;
    private LocalDate anoDeLancamento;
    private double valorDiaria;
    private Tipo tipo;

    // Injetando gestor de alguel - DEPENDENCY INVERSION PRINCIPLE
    private GestorAluguel gestorAluguel;

    public Titulo(UUID id, String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.anoDeLancamento = anoDeLancamento;
        this.valorDiaria = valorDiaria;
        this.gestorAluguel = gestorAluguel;
        this.tipo = tipo;

    }

    //Implemento a classe alugavel pois titulo é um objeto alugavel, porém delego a responsabilidade de gerenciar aluguéis para outra classe - Single Responsability Principle

    @Override
    public void alugar(Aluguel aluguel) {
        this.gestorAluguel.alugar(aluguel);
    }

    @Override
    public void devolver(Aluguel aluguel) {
        this.gestorAluguel.devolver(aluguel);
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Tipo getTipo() {
        return tipo;
    }

}

