package controledefuncionarios.test;

import controledefuncionarios.domain.*;
import controledefuncionarios.exceptions.IllegalSalaryArgumentException;
import controledefuncionarios.exceptions.InvalidOperationTipeException;
import controledefuncionarios.exceptions.InvalidValueBooleanException;
import controledefuncionarios.utils.CPFUtil;

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
            System.out.println("\n--- Menu principal ---");
            System.out.println("\n1. Adicionar novo funcionário");
            System.out.println("2. Listar todos os funcionários");
            System.out.println("3. Holerite dos funcionarios");
            System.out.println("4. Sair do sistema");
            System.out.print("Escolha uma opção: ");

            String opcaoMenu = input.nextLine();

            switch (opcaoMenu) {
                case "1":
                    System.out.print("\nO funcionário é CLT ou PJ? (Digite 'CLT' ou 'PJ'): ");

                    String tipoFuncionario = input.nextLine().trim();

                    try {
                        Funcionario.isValidTipe(tipoFuncionario);
                    } catch (InvalidOperationTipeException e) {
                        e.printStackTrace();
                        continue;
                    }

                    if (tipoFuncionario.equalsIgnoreCase("clt")) {

                        System.out.println("Digite o nome do seu funcionario: ");
                        String nome = input.nextLine();

                        System.out.println("Digite o cpf do seu funcionario: ");
                        String cpf = input.nextLine();

                        if (!CPFUtil.isValidCpf(cpf)) {
                            System.out.println("\nCPF inválido. Operação cancelada.");
                            continue;
                        }

                        System.out.println("Informe o salario do seu funcionario Ex (2000.50)");

                        double salario = -1;

                        try {
                            salario = Double.parseDouble(input.nextLine());
                            Funcionario.isValidSalario(salario);
                        } catch (NumberFormatException e) {
                            System.out.println("\nSalário inválido. Por favor, digite um número valido. Operação cancelada.");
                            continue;
                        } catch (IllegalSalaryArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                            continue;
                        }
                        System.out.println("Possui benefio? (true/false): ");
                        String entrada = input.nextLine().trim();
                        boolean beneficio;
                        try {
                            if (!entrada.equalsIgnoreCase("true") && !entrada.equalsIgnoreCase("false")) {
                                throw new InvalidValueBooleanException("\nErro! O valor digitado não é válido. Digite apenas 'true' ou 'false'. Operação cancelada.");
                            }
                            beneficio = Boolean.parseBoolean(entrada);
                        } catch (InvalidValueBooleanException e) {
                            e.printStackTrace();
                            continue;
                        }

                        System.out.println("Quanto tempo trabalhou na empresa: ");
                        int tempoDeEmpresa = 0;

                        try {
                            tempoDeEmpresa = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("\nTempo inválido. Por favor, digite um número. Operação cancelada.");
                            continue;
                        }

                        funcionarios.add(new FuncionarioClt(nome, cpf, salario, beneficio, tempoDeEmpresa));

                        System.out.println("\nFuncionarioCLT adicionando com sucesso!");

                    } else {
                        System.out.println("Digite o nome do prestador: ");
                        String nome = input.nextLine();

                        System.out.println("Informe o cnpj do prestador: ");
                        String cnpj = input.nextLine();


                        System.out.println("Qual o valor da hora do seu prestador: ");
                        double valorHora = Double.parseDouble(input.nextLine());

                        System.out.println("Quantas horas seu prestador trabalhou: ");
                        int horasTrabalhadas = Integer.parseInt(input.nextLine());

                        System.out.println("Possui bonus? (true/false): ");
                        String entrada = input.nextLine().trim();
                        boolean bonus;
                        try {
                            if (!entrada.equalsIgnoreCase("true") && !entrada.equalsIgnoreCase("false")) {
                                throw new InvalidValueBooleanException("\nErro! O valor digitado não é válido. Digite apenas 'true' ou 'false'. Operação cancelada.");
                            }
                            bonus = Boolean.parseBoolean(entrada);
                        } catch (InvalidValueBooleanException e) {
                            e.printStackTrace();
                            continue;
                        }

                        FuncionarioPj f = new FuncionarioPj(nome, cnpj, valorHora, horasTrabalhadas, bonus);

                        if (bonus) {
                            System.out.println("informe quantas entregas esse prestador relaizou: ");
                            int entregas = 0;

                            try {
                                entregas = Integer.parseInt(input.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("\nQuantidade de entregas inválido. Por favor, digite um número. Operação cancelada.");
                                continue;
                            }

                            f.aplicarBonus(entregas);
                        }

                        funcionarios.add(f);
                        System.out.println("\nFuncionarioPJ adicionando com sucesso!");

                    }
                    continue;

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

                    System.out.println("Realizou horas extras esse mês: ('true' ou 'false'");



                    boolean isHorasExtras;
                    String entrada = input.nextLine().trim();
                    try {
                        if (!entrada.equalsIgnoreCase("true") && !entrada.equalsIgnoreCase("false")) {
                            throw new InvalidValueBooleanException("\nErro! O valor digitado não é válido. Digite apenas 'true' ou 'false'. Operação cancelada.");
                        }
                        isHorasExtras = Boolean.parseBoolean(entrada);
                    } catch (InvalidValueBooleanException e) {
                        e.printStackTrace();
                        continue;
                    }

                    int quantidadeDeHorasExtras = 0;
                    int valorDaHoraExtra = 0;


                    for (int i = 0; i < funcionarios.size(); i++) {

                        if (isHorasExtras) {
                            System.out.println("Quantas horas extras seu funcionario fez: ");
                            quantidadeDeHorasExtras = Integer.parseInt(input.nextLine());

                            System.out.println("Qual o valor da hora para esse funcionario: ");
                            valorDaHoraExtra = Integer.parseInt(input.nextLine());
                        }

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
