package com.softure.rendavariavel.Ipo.domain.rules;

import com.softure.rendavariavel.Ipo.domain.entity.Reserva;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class IpoRules  {

    private final IpoPorQuantidadeComParticipacaoIntegral ipoPorQuantidadeComParticipacaoIntegral;

    private final IpoPorValorComParticipacaoIntegral ipoPorValorComParticipacaoIntegral;

    public IpoRules(IpoPorQuantidadeComParticipacaoIntegral ipoPorQuantidadeComParticipacaoIntegral, IpoPorValorComParticipacaoIntegral ipoPorValorComParticipacaoIntegral) {
        this.ipoPorQuantidadeComParticipacaoIntegral = ipoPorQuantidadeComParticipacaoIntegral;
        this.ipoPorValorComParticipacaoIntegral = ipoPorValorComParticipacaoIntegral;
    }

    public Rule checkRules(Reserva reserva) {
        List<Rule> rules = Arrays.asList(ipoPorQuantidadeComParticipacaoIntegral,
                ipoPorValorComParticipacaoIntegral);

        return rules.stream()
                .filter(rule -> rule.isTrue(reserva))
                .findFirst()
                .get();
    }
}
