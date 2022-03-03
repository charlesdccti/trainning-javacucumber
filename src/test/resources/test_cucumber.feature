# language: pt
Funcionalidade: Aprender Cucumber
	Como aluno
	Eu quero aprender a ultilizar o cucumber
	Para que eu possa automatizar critérios de aceitação
  
Cenario: Deve executar a especificação
  Dado que eu criei o arquivo corretamente 
  Quando executá-lo
  Entao a especificação deve finalizar com sucesso
	
Cenario: Deve incrementar o contador
  Dado que o valor do contador é 15 
  Quando eu incrementar em 3
  Entao o valor do contador será 18
  
Cenario: Deve incrementar o contador
  Dado que o valor do contador é 123 
  Quando eu incrementar em 35
  Entao o valor do contador será 158 

Cenario: Deve calcular o atraso da entrega
  Dado que a entrega é dia 05/04/2018 
  Quando a entrega atrasa em 2 dias
  Entao a entrega será efetuada em 07/04/2018
  
Cenario: Deve calcular o atraso da entrega da china
  Dado que a entrega é dia 05/04/2018 
  Quando a entrega atrasa em 2 meses
  Entao a entrega será efetuada em 05/06/2018