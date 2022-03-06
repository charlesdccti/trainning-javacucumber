package com.charles.services;

import java.util.Calendar;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;
import com.charles.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme) {
		if(filme.getEstoque() == 0 )
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel notaAluguel = new NotaAluguel();
		notaAluguel.setPreco(filme.getAluguel());
		notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		
		return notaAluguel;
	}

}
