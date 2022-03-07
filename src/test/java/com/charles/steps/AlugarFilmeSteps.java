package com.charles.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;
import com.charles.services.AluguelService;
import com.charles.utils.DateUtils;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private String tipoAluguel;
	
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
	    try {
	    	notaAluguel = aluguelService.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
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
	    
	}

	@Dado("que o tipo de aluguel seja extendido")
	public void queOTipoDeAluguelSejaExtendido() {
	    tipoAluguel = "extendido";
	}

	@Entao("a data de entrega será em {int} dias")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
	    Date dataEsperada = DateUtils.obterDataDiferencaDias(1);
	    Date dataReal = notaAluguel.getDataEntrega();
	    
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    
	    Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Entao("a pontuaçao recebida será de {int} pontos")
	public void aPontuaçaoRecebidaSeráDePontos(int int1) {
	    Assert.assertEquals(int1, notaAluguel.getPontuacao());		
	}
}
