package com.softure.rendavariavel.Ipo.service;

import com.softure.rendavariavel.Ipo.domain.entity.Reserva;
import com.softure.rendavariavel.Ipo.domain.rules.IpoRules;
import org.springframework.stereotype.Service;

@Service
public class ReservaApplyService {

    private final IpoRules ipoRules;

    public ReservaApplyService(IpoRules ipoRules) {
        this.ipoRules = ipoRules;
    }

    public Reserva getReservaEfetiva(Reserva reserva) {
        return ipoRules.checkRules(reserva)
                .apply(reserva);
    }
}
