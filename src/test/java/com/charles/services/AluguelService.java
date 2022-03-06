package com.charles.services;

import java.util.Calendar;

import com.charles.entities.Filme;
import com.charles.entities.NotaAluguel;

public class AluguelService {

	public NotaAluguel alugar(Filme filme) {
		NotaAluguel notaAluguel = new NotaAluguel();
		notaAluguel.setPreco(filme.getAluguel());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		notaAluguel.setDataEntrega(cal.getTime());
		filme.setEstoque(filme.getEstoque() - 1);
		
		return notaAluguel;
	}

}
