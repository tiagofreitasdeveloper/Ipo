package com.softure.rendavariavel.Ipo.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Ipo {

    private Empresa empresa;

    private String simboloAtivo;

    private Double valorUnitario;

    private List<Reserva> reservas;

    private Double percentualGarantiaExigida;

    private Double valorMinimo;

    private Long quantidadeMinima;

    private boolean ofertaPrioritaria;

    public Double getValorGarantiaMinimaExigida() {
        return valorMinimo * percentualGarantiaExigida;
    }

}
