package com.softure.rendavariavel.Ipo.domain.rules;

import com.softure.rendavariavel.Ipo.domain.entity.Reserva;

public interface Rule {

    boolean isTrue(Reserva reserva);

    Reserva apply(Reserva reserva);
}
