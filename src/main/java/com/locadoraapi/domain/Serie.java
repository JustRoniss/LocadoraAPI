package com.locadoraapi.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Serie extends Titulo{
    public Serie(UUID id, String nome, String diretor, LocalDate anoDeLancamento, double valorDiaria, GestorAluguel gestorAluguel, boolean disponivel, UUID aluguelId) {
        super(id, nome, diretor, anoDeLancamento, valorDiaria, gestorAluguel, Tipo.SERIE, disponivel, aluguelId);
    }
}
