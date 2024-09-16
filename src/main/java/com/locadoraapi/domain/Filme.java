package com.locadoraapi.domain;

import java.time.LocalDate;

public class Filme extends Titulo{
    public Filme(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria) {
        super(nome, diretor, anoDeLancamento, valorDiaria);
    }

    protected Filme() {
    }
}
