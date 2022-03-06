# language: pt
Funcionalidade: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega
	
	
Cenario: Deve alugar um filme com sucesso
  Dado um filme com estoque de 2 unidades
  E que o preço de aluguel seja R$ 3  
  Quando alugar
  Entao o preço do aluguel será R$ 3 
  E a data de entrega será no dia seguinte
  E o estoque do filme será 1 unidade.
  
Cenario: Não deve alugar filme sem sucesso
  Dado um filme com estoque de 0 unidades
  E que o preço de aluguel seja R$ 3  
  Quando alugar
  Entao nao será possível por falta de estoque
  E o estoque do filme será 0 unidade.

  
  