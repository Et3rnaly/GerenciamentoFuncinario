package controledefuncionarios.service;

import controledefuncionarios.domain.*;
import controledefuncionarios.exceptions.IllegalSalaryArgumentException;
import controledefuncionarios.exceptions.InvalidOperationTipeException;
import controledefuncionarios.exceptions.InvalidValueBooleanException;
import controledefuncionarios.utils.CPFUtil;
import controledefuncionarios.utils.SortByCpfComparator;

import java.util.*;

public class FuncionarioService {
    Scanner input = new Scanner(System.in);
    NavigableSet<Funcionario> funcionarios = new TreeSet<>(new SortByCpfComparator());
    Map<String, List<Funcionario>> funcionariosMap = new HashMap<>();
    List<Funcionario> funcionarioList = new ArrayList<>();

    public void addNewFuncionario() {
        System.out.print("\nO funcionário é CLT ou PJ? (Digite 'CLT' ou 'PJ'): ");

        String tipoFuncionario = input.nextLine().trim().toUpperCase();

        try {
            Funcionario.isValidTipe(tipoFuncionario);
        } catch (InvalidOperationTipeException e) {
            e.fillInStackTrace();
            return;
        }

        if (tipoFuncionario.equalsIgnoreCase("clt")) {

            System.out.println("Digite o nome do seu funcionario: ");
            String nome = input.nextLine();

            System.out.println("Digite o cpf do seu funcionario: ");
            String cpf = input.nextLine();

            if (!CPFUtil.isValidCpf(cpf)) {
                System.out.println("\nCPF inválido. Operação cancelada.");
                return;
            }

            System.out.println("Informe o salario do seu funcionario Ex (2000.50)");

            double salario;

            try {
                salario = Double.parseDouble(input.nextLine());
                Funcionario.isValidSalario(salario);
            } catch (NumberFormatException e) {
                System.out.println("\nSalário inválido. Por favor, digite um número valido. Operação cancelada.");
                return;
            } catch (IllegalSalaryArgumentException e) {
                System.out.println("\n" + e.getMessage());
                return;
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
                e.fillInStackTrace();
                return;
            }

            System.out.println("Quanto tempo trabalhou na empresa: ");
            int tempoDeEmpresa;

            try {
                tempoDeEmpresa = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nTempo inválido. Por favor, digite um número. Operação cancelada.");
                return;
            }

            FuncionarioClt f = new FuncionarioClt(nome, cpf, salario, beneficio, tempoDeEmpresa);
            funcionarioList.add(f);

            funcionarios.add(f);
            funcionariosMap.computeIfAbsent(tipoFuncionario, _ -> new ArrayList<>()).add(f);


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
                e.fillInStackTrace();
                return;
            }

            FuncionarioPj f = new FuncionarioPj(nome, cnpj, valorHora, horasTrabalhadas, bonus);

            if (bonus) {
                System.out.println("informe quantas entregas esse prestador relaizou: ");
                int entregas;

                try {
                    entregas = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("\nQuantidade de entregas inválido. Por favor, digite um número. Operação cancelada.");
                    return;
                }

                f.aplicarBonus(entregas);
            }

            funcionarios.add(f);
            funcionarioList.add(f);
            funcionariosMap.computeIfAbsent(tipoFuncionario, _ -> new ArrayList<>()).add(f);
            System.out.println("\nFuncionarioPJ adicionando com sucesso!");

        }
    }

    public void listFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nVocê ainda não possui funcionarios.");
            return;
        }

        System.out.println("Qual tipo de funcionário deseja listar? (CLT / PJ / TODOS)");
        String tipo = input.nextLine().trim().toUpperCase();

        if (tipo.equals("TODOS")) {
            for (List<Funcionario> list : funcionariosMap.values()) {
                for (Funcionario f : list)
                    f.exbirDados();
            }
        } else if (funcionariosMap.containsKey(tipo)) {

            List<Funcionario> listaTipo = funcionariosMap.get(tipo);

            for (Funcionario f : listaTipo) {
                f.exbirDados();
            }

        } else {
            System.out.println("Tipo inválido. Digite CLT, PJ ou TODOS.");
        }
    }

    public void paySlipFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nVocê ainda não possui funcionarios.");
            return;
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
            e.fillInStackTrace();
            return;
        }

        int quantidadeDeHorasExtras = 0;
        int valorDaHoraExtra = 0;


        for (Funcionario funcionario : funcionarios) {

            if (isHorasExtras) {
                System.out.println("Quantas horas extras seu funcionario fez: ");
                quantidadeDeHorasExtras = Integer.parseInt(input.nextLine());

                System.out.println("Qual o valor da hora para esse funcionario: ");
                valorDaHoraExtra = Integer.parseInt(input.nextLine());
            }

            ContratoDeTrabalho novoCotrato = new ContratoDeTrabalho(funcionario, valorDaHoraExtra, quantidadeDeHorasExtras);

            Holerite novoHolerite = new Holerite(novoCotrato);

            novoHolerite.imprimirHolerite();
        }
    }

    public void exitConsole() {
        System.out.println("Saindo do progama, ate logo!");
        input.close();
    }


}
