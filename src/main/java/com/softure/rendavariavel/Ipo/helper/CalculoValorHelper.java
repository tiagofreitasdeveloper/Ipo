package com.softure.rendavariavel.Ipo.helper;

public class CalculoValorHelper {

    public static Double calcularValor(Long quantidade, Double preco) {
        return quantidade * preco;
    }

    public static Double calcularValor(Double quantidade, Double preco) {
        return quantidade * preco;
    }

    public static boolean isBetween(Double startValue, Double endValue, Double currentValue) {
        return currentValue >= startValue && currentValue < endValue;
    }
}
