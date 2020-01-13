package com.softure.rendavariavel.Ipo.domain.rules;

import com.softure.rendavariavel.Ipo.domain.entity.Ipo;
import com.softure.rendavariavel.Ipo.domain.entity.Reserva;
import com.softure.rendavariavel.Ipo.domain.entity.conta.Conta;
import com.softure.rendavariavel.Ipo.service.IpoService;
import com.softure.rendavariavel.Ipo.service.ReservaService;
import com.softure.rendavariavel.Ipo.service.TipoDeParticipacao;
import org.springframework.stereotype.Service;

@Service
public class IpoPorQuantidadeComParticipacaoIntegral implements Rule {

    private final IpoService ipoService;

    private final ReservaService reservaService;

    public IpoPorQuantidadeComParticipacaoIntegral(IpoService ipoService, ReservaService reservaService) {
        this.ipoService = ipoService;
        this.reservaService = reservaService;
    }

    @Override
    public boolean isTrue(Reserva reserva) {
        Ipo ipo = reserva.getIpo();
        Conta conta = reserva.getConta();

        Double garantiaExigida = reservaService.getValorGarantiaExigida(reserva.getQuantidadeAtivos(),
                ipo.getPercentualGarantiaExigida());

        return !ipo.isOfertaPrioritaria()
                && ipoService.isIpoPorQuantidade(ipo.getQuantidadeMinima())
                && TipoDeParticipacao.isIntegral(conta.getLimiteOperacional(), garantiaExigida);
    }

    @Override
    public Reserva apply(Reserva reserva) {
        Ipo ipo = reserva.getIpo();
        Double valorEfetivo = reservaService.getValorDaQuantidadeReservada(reserva.getQuantidadeAtivos(),
                ipo.getValorUnitario());
        return Reserva.builder()
                .conta(reserva.getConta())
                .ipo(reserva.getIpo())
                .quantidadeAtivos(reserva.getQuantidadeAtivos())
                .quantidadeEfetiva(reserva.getQuantidadeEfetiva())
                .valorEfetivo(valorEfetivo)
                .build();
    }
}
