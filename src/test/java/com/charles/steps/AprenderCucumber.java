package com.charles.steps;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AprenderCucumber {

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
	//@Dado("^que o valor do contador é (\\d+)$")
	@Dado("que o valor do contador é {int}")
	public void queOValorDoContadorÉ(Integer int1) {
		contador = int1;
	}

	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) {
		contador = contador + int1;
	}

	@Entao("o valor do contador será {int}")
	public void oValorDoContadorSerá(Integer int1) {
	   
		Assert.assertEquals(int1, contador);
	}
	
}
