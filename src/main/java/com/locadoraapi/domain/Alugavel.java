package com.locadoraapi.domain;

public interface Alugavel {
    void alugar(Aluguel aluguel);
    void devolver(Aluguel aluguel);
}
