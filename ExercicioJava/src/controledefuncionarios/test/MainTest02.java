package controledefuncionarios.test;

import controledefuncionarios.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();
        List<ContratoDeTrabalho> contratos = new ArrayList<>();
        List<Holerite> holerites = new ArrayList<>();

        System.out.println("Bem-vindo ao sistema de gerenciamento de funcionários!");

        while (true) {
            System.out.printf("\n--- Menu principal ---");
            System.out.println("\n1. Adicionar novo funcionário");
            System.out.println("2. Listar todos os funcionários");
            System.out.println("3. Holerite dos funcionarios");
            System.out.println("4. Sair do sistema");
            System.out.print("Escolha uma opção: ");

            String opcaoMenu = input.nextLine();

            switch (opcaoMenu) {
                case "1":
                    System.out.print("\nO funcionário é CLT ou PJ? (Digite 'CLT' ou 'PJ'): ");
                    String tipoFuncionario = input.nextLine();

                    System.out.println("Digite o nome do seu funcionario: ");
                    String nome = input.nextLine();

                    System.out.println("Digite o cpf do seu funcionario: ");
                    String cpf = input.nextLine();

                    System.out.println("Informe o salario do seu funcionario Ex (2000.50)");
                    double salario = Double.parseDouble(input.nextLine());

                    if (tipoFuncionario.equalsIgnoreCase("clt")) {
                        System.out.println("Possui benefio? (true/false): ");
                        boolean benefio = Boolean.parseBoolean(input.nextLine());

                        System.out.println("Quanto tempo trabalhou na empresa: ");
                        int tempoDeEmpresa = Integer.parseInt(input.nextLine());

                        funcionarios.add(new FuncionarioClt(nome, cpf, salario, benefio, tempoDeEmpresa));

                        System.out.println("\nFuncionarioCLT adicionando com sucesso!");

                        continue;

                    } else {
                        System.out.println("Informe o cnpj do funcionario: ");
                        String cnpj = input.nextLine();

                        System.out.println("informe quantas entregas esse funcionario relaizou: ");
                        int entregas = Integer.parseInt(input.nextLine());

                        funcionarios.add(new FuncionarioPj(nome, cpf, cnpj, salario, entregas));
                        System.out.println("\nFuncionarioPJ adicionando com sucesso!");

                        continue;
                    }

                case "2":
                    if (funcionarios.isEmpty()) {
                        System.out.println("\nVocê ainda não possui funcionarios.");
                        continue;
                    }

                    for (Funcionario f : funcionarios) {
                        f.exbirDados();
                    }

                    continue;

                case "3":
                    if (funcionarios.isEmpty()) {
                        System.out.println("\nVocê ainda não possui funcionarios.");
                        continue;
                    }

                    for (int i = 0; i < funcionarios.size(); i++) {
                        System.out.println("Quantas horas extras seu funcionario fez: ");
                        int quantidadeDeHorasExtras = Integer.parseInt(input.nextLine());

                        System.out.println("Qual o valor da hora para esse funcionario: ");
                        int valorDaHoraExtra = Integer.parseInt(input.nextLine());

                       ContratoDeTrabalho novoCotrato = new ContratoDeTrabalho(funcionarios.get(i), valorDaHoraExtra, quantidadeDeHorasExtras);

                       Holerite novoHolerite = new Holerite(novoCotrato);

                       novoHolerite.imprimirHolerite();
                    }

                    continue;

                case "4":
                    System.out.println("Saindo do progama, ate logo!");
                    input.close();
                    return;
            }

        }

    }
}
