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
  Quando eu incrementar em 5
  Entao o valor do contador será 18