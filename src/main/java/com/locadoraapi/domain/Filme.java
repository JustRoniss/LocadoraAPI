package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Filme extends Titulo{
    public Filme(UUID id, String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel) {
        super(id, nome, diretor, anoDeLancamento, valorDiaria, gestorAluguel, Tipo.FILME);
    }

}
