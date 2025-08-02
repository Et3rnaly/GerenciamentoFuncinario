Gerenciamento de Funcionários

Este projeto Java é um sistema de gerenciamento de funcionários que demonstra conceitos de Programação Orientada a Objetos (POO), incluindo herança, polimorfismo e o uso de enums para regras de negócio. O sistema permite o cálculo de salários para diferentes tipos de funcionários (CLT e PJ), aplicando descontos de INSS e benefícios.

Funcionalidades

•
Cálculo de Salário CLT: Calcula o salário de funcionários CLT, considerando salário base, benefícios (vale transporte) e descontos de INSS.

•
Cálculo de Salário PJ: (Em desenvolvimento) Previsão de cálculo de salário para funcionários PJ, com bônus por projetos entregues.

•
Estrutura de Classes: Utiliza classes como Funcionario (abstrata), FuncionarioClt, FuncionarioPj, ContratoDeTrabalho, Holerite e enums para FaixaINSS e FaixaSalario.

•
Interatividade: Permite a entrada de dados de funcionários via console para simulação de cálculos.

•
Regras de Negócio: Implementa as regras de cálculo de INSS baseadas em faixas salariais e o cálculo de 13º salário para funcionários CLT.

Estrutura do Projeto

O projeto está organizado da seguinte forma:

Plain Text


GerenciamentoFuncinario/
├── ExercicioJava/
│   ├── src/
│   │   ├── controledefuncionarios/
│   │   │   ├── domain/             # Classes de domínio (Funcionario, ContratoDeTrabalho, Holerite, etc.)
│   │   │   ├── enums/              # Enums para regras de negócio (FaixaINSS, FaixaSalario)
│   │   │   └── test/               # Classes de teste e execução principal (Main.java)
│   └── ...
└── ...


Como Executar

Para executar este projeto, você precisará de um ambiente de desenvolvimento Java (JDK) instalado (versão 8 ou superior).

1.
Clone o Repositório:

2.
Compile o Projeto:

3.
Execute a Aplicação:

Próximos Passos e Melhorias Potenciais

•
Completar a implementação do cálculo de salário para FuncionarioPj.

•
Adicionar validações de entrada para garantir a robustez do sistema.

•
Implementar testes unitários para as classes de domínio.

•
Considerar a criação de uma interface gráfica (GUI) ou uma API REST para interação com o sistema.

•
Melhorar a documentação Javadoc para todas as classes e métodos.

Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias e correções de bugs.

Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes. (Assumindo licença MIT, se houver um arquivo LICENSE no repositório, por favor, verifique e ajuste.)

