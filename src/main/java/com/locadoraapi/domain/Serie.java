package com.locadoraapi.domain;

import java.time.LocalDate;

public class Serie extends Titulo{
    public Serie(String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel) {
        super(nome, diretor, anoDeLancamento, valorDiaria, gestorAluguel, Tipo.SERIE);
    }

}
