# Vantagens e desvantagens
Primeiramente, é importante ressaltar que o BDD, segundo seu criador Dan North, 
não foi criado com o propósito de anular as práticas de TDD, mas sim adicionar a elas algumas vantagens.

Dentre as principais vantagens da utilização do BDD, podemos destacar:

- Alinhamento da comunicação entre equipes, uma vez que o processo é realizado em conjunto e utilizando linguagem ubíqua;
- Documentação dinâmica, pois os frameworks de BDD geram esses artefatos dinamicamente sem esforço adicional, facilitando a manutenção;
- Visão do todo, pois é realizada a definição do comportamento das funcionalidades do projeto antes de iniciar a codificação, minimizando erros e manutenções menos custosas;
- Manter o foco no essencial, pois o BDD requer códigos focados apenas no necessário para o teste de comportamento passar, auxiliando a não incluir códigos que somente serão utilizados no futuro ou que são desnecessários, minimizando recursos de tempo e orçamento;
- Criar uma conexão entre o negócio e os testes, para que os objetivos do software sejam alcançados.

Já dentre as principais desvantagens, podemos citar:

- Testes comportamentais (BDD) tendem a ser mais lentos para rodar que os testes unitários (TDD), pois rodam o conjunto de testes de todas as funcionalidades do software juntos;
- BDD não identifica a causa do problema. Testes comportamentais, quando falham, indicam somente que algo deu errado, mas pode dar pouca ou nenhuma indicação da causa raiz. O TDD, ao contrário, fornece indicações da causa do problema, uma vez que testa cada funcionalidade separadamente.

# Conclusão
As técnicas de teste ágeis são muito utilizadas atualmente. A principal e mais conhecidas delas é o TDD. Contudo, o BDD vem ganhando espaço e importância, uma vez que preenche lacunas geradas pelo TDD.

A principal dessas lacunas é o desalinhamento entres as equipes relacionadas ao projeto em relação à definição do comportamento das funcionalidades do software, bem como a desorientação frequente dos desenvolvedores em relação ao que deve ou não ser testado e em qual ordem. Nesse sentido, a aplicação do BDD em conjunto com times diversos utilizando linguagem ubíqua promove não só o alinhamento das equipes, mas também economias (de tempo e orçamento), minimiza erros e possíveis refatorações.

Existem diversas ferramentas para implementação do BDD, sendo as mais conhecidas o Cucumber (Ruby), Behat (Php), JBehave (Java), Jasmine (JS) e Behave (Python). É possível, ainda, aplicar a técnica sem utilização de ferramentas específicas. Cabe a cada empresa decidir qual é mais adequada para sua realidade e habilidades de suas equipes.

É importante ressaltar também que o BDD não tem por objetivo substituir o TDD, mas sim complementá-lo, podendo ambos serem empregados no mesmo projeto.

#### Segue a url desse artigo na integra:https://medium.com/@jessica.fpeixoto/bdd-vs-tdd-qual-o-melhor-83fd8df7f662#8aa1
