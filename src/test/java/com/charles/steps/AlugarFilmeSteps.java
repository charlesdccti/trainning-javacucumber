package com.charles.steps;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;
import com.charles.services.AluguelService;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	
	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer int1) {
		filme = new Filme();
		filme.setEstoque(int1);
	}

	@Dado("que o preço de aluguel seja R$ {int}")
	public void queOPreçoDeAluguelSejaR$(Integer int1) {
	    filme.setAluguel(int1);
	}

	@Quando("alugar")
	public void alugar() throws Throwable {
	    notaAluguel = aluguelService.alugar(filme);
	}

	@Entao("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPreco());
	}

	@Entao("a data de entrega será no dia seguinte")
	public void aDataDeEntregaSeráNoDiaSeguinte() {
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, 1);
	    
	    Date dataRetorno = notaAluguel.getDataEntrega();
	    Calendar calRetorno = Calendar.getInstance();
	    calRetorno.setTime(dataRetorno);
	    
	    Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
	    Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));	
	    Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
	}
	

	@Entao("o estoque do filme será {int} unidade.")
	public void oEstoqueDoFilmeSeráUnidade(int int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}

	@Entao("nao será possível por falta de estoque")
	public void naoSeráPossívelPorFaltaDeEstoque() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Dado("que o tipo de aluguel seja extendido")
	public void queOTipoDeAluguelSejaExtendido() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Entao("a data de entrega será em {int} dias")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Entao("a pontuaçao recebida será de {int} pontos")
	public void aPontuaçaoRecebidaSeráDePontos(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();		
	}
}
