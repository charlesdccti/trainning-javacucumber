package com.charles.entities;

import java.util.Date;

public class NotaAluguel {

	private Integer preco;
	private Date dataEntrega; 
	private int pontuacao;
	
	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date time) {
		this.dataEntrega = time;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
