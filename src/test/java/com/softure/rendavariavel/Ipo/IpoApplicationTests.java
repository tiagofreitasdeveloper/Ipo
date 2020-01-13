package com.softure.rendavariavel.Ipo;

import com.softure.rendavariavel.Ipo.domain.entity.Ipo;
import com.softure.rendavariavel.Ipo.domain.entity.Reserva;
import com.softure.rendavariavel.Ipo.domain.entity.conta.Conta;
import com.softure.rendavariavel.Ipo.domain.rules.IpoPorQuantidadeComParticipacaoIntegral;
import com.softure.rendavariavel.Ipo.domain.rules.IpoPorValorComParticipacaoIntegral;
import com.softure.rendavariavel.Ipo.domain.rules.IpoRules;
import com.softure.rendavariavel.Ipo.service.IpoService;
import com.softure.rendavariavel.Ipo.service.ReservaApplyService;
import com.softure.rendavariavel.Ipo.service.ReservaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = IpoApplicationTests.class)
class IpoApplicationTests {

	@MockBean
	ReservaService reservaService;
	@MockBean
	IpoRules ipoRules;

	@Test
	void contextLoads() {
		Ipo ipo = Ipo.builder()
				.ofertaPrioritaria(false)
				.quantidadeMinima(10L)
				.valorUnitario(100D)
				.percentualGarantiaExigida(0.2)
				.build();

		Conta conta = Conta.builder()
				.limite(1000D)
				.build();

		Reserva reserva = Reserva.builder()
				.ipo(ipo)
				.conta(conta)
				.quantidadeAtivos(5000L)
				.build();

		IpoService ipoService = new IpoService();
		ReservaService reservaService = new ReservaService();

		IpoPorQuantidadeComParticipacaoIntegral ipoPorQuantidadeComParticipacaoIntegral = new IpoPorQuantidadeComParticipacaoIntegral(
				ipoService,
				reservaService);

		IpoPorValorComParticipacaoIntegral ipoPorValorComParticipacaoIntegral = new IpoPorValorComParticipacaoIntegral(
				ipoService,
				reservaService);

		ReservaApplyService reservaApplyService = new ReservaApplyService(new IpoRules(ipoPorQuantidadeComParticipacaoIntegral,
				ipoPorValorComParticipacaoIntegral));
		Reserva reservaEfetiva = reservaApplyService.getReservaEfetiva(reserva);

		System.out.println(reservaEfetiva.getValorEfetivo());

	}

}
