package controledefuncionarios.app;

import controledefuncionarios.service.FuncionarioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FuncionarioService funcionarioService = new FuncionarioService();

        System.out.println("Bem-vindo ao sistema de gerenciamento de funcionários!");

        while (true) {
            System.out.println("\n--- Menu principal ---");
            System.out.println("\n1. Adicionar novo funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Holerite dos funcionarios");
            System.out.println("4. Sair do sistema");
            System.out.print("Escolha uma opção: ");

            String opcaoMenu = input.nextLine();

            switch (opcaoMenu) {
                case "1":

                    funcionarioService.addNewFuncionario();
                    continue;

                case "2":

                    funcionarioService.listFuncionarios();
                    continue;

                case "3":

                    funcionarioService.paySlipFuncionarios();
                    continue;

                case "4":

                    funcionarioService.exitConsole();
                    return;
            }

        }

    }
}
