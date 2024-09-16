package com.locadoraapi.domain;


import java.time.LocalDate;
import java.util.UUID;


public abstract class Titulo implements Alugavel {

    private UUID id;
    private String nome;
    private String diretor;
    private LocalDate anoDeLancamento;
    private double valorDiaria;
    private Aluguel aluguel;
    private boolean disponivel;

    public Titulo(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.diretor = diretor;
        this.anoDeLancamento = anoDeLancamento;
        this.valorDiaria = valorDiaria;
    }

    @Override
    public void alugar(Aluguel aluguel){
        if(disponivel){
            this.aluguel = aluguel;
            this.disponivel = false;
        }
    }

    @Override
    public void desalugar(Aluguel aluguel){

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

    public Aluguel getAluguel() {
        return aluguel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

