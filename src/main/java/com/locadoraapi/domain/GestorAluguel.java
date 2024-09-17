package com.locadoraapi.domain;

public class GestorAluguel {

    private boolean disponivel = true;
    private Aluguel aluguel;

    public void alugar(Aluguel aluguel) {
        if(this.disponivel) {
            this.aluguel = aluguel;
            this.disponivel = false;
        }else{
            throw new IllegalStateException("Este título já está alugado.");
        }
    }

    public void devolver(Aluguel aluguel) {
        if(!this.disponivel) {
            this.aluguel = null;
            this.disponivel = true;
        }else {
            throw new IllegalStateException("Este título não está alugado.");
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
