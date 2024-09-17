package com.locadoraapi.domain;

import java.time.LocalDate;

public class Filme extends Titulo{
    public Filme(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel) {
        super(nome, diretor, anoDeLancamento, valorDiaria, gestorAluguel, Tipo.FILME);
    }

}
