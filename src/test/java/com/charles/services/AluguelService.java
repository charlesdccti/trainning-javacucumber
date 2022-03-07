package com.charles.services;

import java.util.Calendar;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;
import com.charles.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, String tipo) {
		if(filme.getEstoque() == 0 )
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel notaAluguel = new NotaAluguel();
		if("extendido".equals(tipo)) {
			notaAluguel.setPreco(filme.getAluguel() * 2);
			notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			notaAluguel.setPontuacao(2);
		}	else {
			notaAluguel.setPreco(filme.getAluguel());
			notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			notaAluguel.setPontuacao(1);
		}
		notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		
		return notaAluguel;
	}

}
