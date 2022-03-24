package com.charles.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;
import com.charles.entities.TipoAluguel;
import com.charles.services.AluguelService;
import com.charles.utils.DateUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer int1) {
		filme = new Filme();
		filme.setEstoque(int1);
	}
	
	@Dado("um filme")
	public void umFilme(DataTable dataTable) {
	    Map<String, String> map = dataTable.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Dado("que o preço do aluguel seja R$ {int}")
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
	public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}

	@Entao("nao será possível por falta de estoque")
	public void naoSeráPossívelPorFaltaDeEstoque() {
		Assert.assertEquals("Filme sem estoque", erro);
	}

	@Dado("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDeAluguelSejaExtendido(String tipo) {
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Entao("a data de entrega será em {int} dias")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
	    Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
	    Date dataReal = notaAluguel.getDataEntrega();
	    
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    
	    Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Entao("a pontuação será de {int} pontos")
	public void aPontuaçaoRecebidaSeráDePontos(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPontuacao());		
	}
}
