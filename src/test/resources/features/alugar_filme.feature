# language: pt
Funcionalidade: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega
	
	
Cenario: Deve alugar um filme com sucesso
  Dado um filme 
  	|	estoque | 2					|
  	| preco		|	3					|
  	| tipo		| comum			|
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
  
Esquema do Cenário: Deve dar condições conforme tipo de aluguel
	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja R$ <preco>
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor>
	E a data de entrega será em <qtdDias> dias
	E a pontuação será de <pontuacao> pontos
	
Exemplos:
	| preco | tipo      | valor | qtdDias | pontuacao |
	|   4   | extendido |   8   |   3     |     2     |
	|   4   |   comum   |   4   |   1     |     1     |
	|  10   | extendido |  20   |   3     |     2     |
	|  5    |  semanal  |  15   |   7     |     3     |
  