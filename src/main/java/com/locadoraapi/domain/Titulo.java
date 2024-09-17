package com.locadoraapi.domain;


import java.time.LocalDate;
import java.util.UUID;


public abstract class Titulo implements Alugavel{

    private UUID id;
    private String nome;
    private String diretor;
    private LocalDate anoDeLancamento;
    private double valorDiaria;
    private Tipo tipo;

    // Injetando gestor de alguel - DEPENDENCY INVERSION PRINCIPLE
    private GestorAluguel gestorAluguel;



    public Titulo(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel, Tipo tipo) {
        this.id = UUID.randomUUID();
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

