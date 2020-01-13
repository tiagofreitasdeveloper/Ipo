package com.softure.rendavariavel.Ipo.service;

import com.softure.rendavariavel.Ipo.helper.CalculoValorHelper;

public class TipoDeParticipacao {

    public static boolean isIntegral(Double limiteOperacional, Double valorGarantiaExigida) {
        return limiteOperacional >= valorGarantiaExigida;
    }

    public static boolean isParcial(Double limiteOperacional, Double valorGarantiaExigida, Double valorMinimoGarantia) {
        return CalculoValorHelper.isBetween(valorMinimoGarantia, valorGarantiaExigida, limiteOperacional);
    }

    public static boolean naoParticipavel(Double limiteOperacional, Double valorMinimoGarantia) {
        return valorMinimoGarantia > limiteOperacional;
    }
}
