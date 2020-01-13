package com.softure.rendavariavel.Ipo.service;

import com.softure.rendavariavel.Ipo.helper.CalculoValorHelper;
import org.springframework.stereotype.Service;

@Service
public class IpoService {

    public Double getValorMinimo(Long quantidadeMinima, Double precoUnitario) {
        return CalculoValorHelper.calcularValor(quantidadeMinima, precoUnitario);
    }

    public Double getValorGarantiaMinima(Double valorMinimo, Double percentualGarantia) {
        return CalculoValorHelper.calcularValor(valorMinimo, percentualGarantia);
    }

    public boolean isIpoPorValor(Long quantidadeMinima) {
        return quantidadeMinima == null;
    }

    public boolean isIpoPorQuantidade(Long quantidadeMinima) {
        return !isIpoPorValor(quantidadeMinima);
    }

}
