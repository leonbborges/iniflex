# iniflex

A aplicação se propõe a partir de uma base de dados disponibilzaado em uma tabela, 
pegar esses dados e faz as seguintes tarefas:

– Inserir todos os funcionários, na mesma ordem e informações da tabela acima.<br/>
– Remover o funcionário “João” da lista.<br/>
– Imprimir todos os funcionários com todas suas informações, sendo que:<br/>
• informação de data deve ser exibido no formato dd/mm/aaaa;<br/>
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.<br/>
– Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.<br/>
– Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.<br/>
– Imprimir os funcionários, agrupados por função.<br/>
– Imprimir os funcionários que fazem aniversário no mês 10 e 12.<br/>
– Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.<br/>
– Imprimir a lista de funcionários por ordem alfabética.<br/>
– Imprimir o total dos salários dos funcionários.<br/>
– Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.<br/>

A base de dados original é essa:
![Tabela com os dados](Imagens/tabela.png)<br/>

essa tabela foi convertida em um json com na pode ser vistos na classe, [tabela em json](src/main/resources/demo.json)
e a partir disso pode ser feitos as diversas operações.

Lingaguem: foi usado o java na sua versão 22.01 
<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java&theme=light" />
  </a>
</p>
Ferramenta: Intellij na sua versão 2024

O codigo possuir o menu:
Escolha uma das opçoes:<br/>
1- para listar todos os funcionarios<br/>
2- para deletar um funcionario em especifico.<br/>
3- para reajustar o salario em 10% e imprimir Funcionarios com salario ajustado<br/>
4- para imprimir funcionarios que fazem aniversario nesses mese<br/>
5- para ver o funcionario com maior idade<br/>
6- para ver numero de salarios minimos de cada funcionario<br/>
7- para ver o somatorio dos salarios dos funcionarios<br/>
8- para ver a lista odernada<br/>
9- para imprimir o agrupamento de funcionarios<br/>
-sair
