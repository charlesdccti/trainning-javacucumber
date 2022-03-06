package com.charles.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("que eu criei o arquivo corretamente")
	public void queEuCrieiOArquivoCorretamente()  throws Throwable {
		System.out.println("qualquer coisa!!");
	}

	@Quando("executá-lo")
	public void executáLo() {

	}

	@Entao("a especificação deve finalizar com sucesso")
	public void aEspecificaçãoDeveFinalizarComSucesso() {
		System.out.println("qualquer coisa");
	}

	private Integer contador = 0;
	@Dado("que o valor do contador é (\\d+)")
	public void queOValorDoContadorÉ(Integer int1) {
		contador = int1;
	}

	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) {
		contador = contador + int1;
	}

	@Entao("o valor do contador será (\\d+)")
	public void oValorDoContadorSerá(Integer int1) {
	   Assert.assertEquals(int1, contador);
	}
	
	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, dia);
	    cal.set(Calendar.MONTH, mes - 1);
	    cal.set(Calendar.YEAR, ano);
	    entrega = cal.getTime();
	}

	@Quando("^a entrega atrasa em (\\d+) (dias|meses)$")
	public void aEntregaAtrasaEmDias(Integer int1, String tempo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if(tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, int1);
		}
		if(tempo.equals("meses")) {
			cal.add(Calendar.MONTH, int1);
		}
		entrega = cal.getTime();
	}

	@Entao("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataformatada = format.format(entrega);
	    Assert.assertEquals(data, dataformatada);
	}
	
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
		
	}

	@Dado("que o valor da passagem é R$ {double}")
	public void queOValorDaPassagemÉR$(Double numero) {
		System.out.println(numero);
	}

	@Dado("que o nome do passageiro é {string}")
	public void queONomeDoPassageiroÉ(String string) {
		
	}

	@Dado("que o telefone do passageiro é {int}-{int}")
	public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) {
		
	}

	@Quando("criar os steps")
	public void criarOsSteps() {
		
	}

	@Então("o teste vai funcionar")
	public void oTesteVaiFuncionar() {
		
	}
	
}
