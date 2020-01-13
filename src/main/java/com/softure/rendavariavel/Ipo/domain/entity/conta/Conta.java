package com.softure.rendavariavel.Ipo.domain.entity.conta;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Conta {

    private String numero;

    private Double saldo;

    private Double limite;

    public Double getLimiteOperacional() {
        return this.limite;
    }

    public String getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

}
