package com.softure.rendavariavel.Ipo.service;

import com.softure.rendavariavel.Ipo.helper.CalculoValorHelper;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    public Double getValorDaQuantidadeReservada(long quantidadeReservada, Double precoUnitario) {
        return CalculoValorHelper.calcularValor(quantidadeReservada, precoUnitario);
    }

    public Long getQuantidadeReservada(Double valorReserva, Double precoUnitario) {
        return Double.valueOf(valorReserva / precoUnitario).longValue();
    }

    public Double getValorGarantiaExigida(long quantidadeReservada, Double percentualGarantiaExigida) {
        return CalculoValorHelper.calcularValor(quantidadeReservada, percentualGarantiaExigida);
    }

}
