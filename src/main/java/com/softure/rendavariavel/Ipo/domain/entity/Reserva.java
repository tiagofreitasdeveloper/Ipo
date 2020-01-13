package com.softure.rendavariavel.Ipo.domain.entity;

import com.softure.rendavariavel.Ipo.domain.entity.conta.Conta;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Reserva {

    private Conta conta;

    private Ipo ipo;

    private Long quantidadeAtivos;

    private Long quantidadeEfetiva;

    private Double valorEfetivo;

}
