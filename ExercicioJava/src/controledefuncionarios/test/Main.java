package controledefuncionarios.test;

import controledefuncionarios.domain.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        Funcionario[] funcionarios = new Funcionario[3];
//        funcionarios[0] = new FuncionarioClt("Marcos", "111.111.111-50", 1520.0, true, 12);
//        funcionarios[1] = new FuncionarioClt("Julinha", "222.111.333-50", 3250.2, false, 8);
//        funcionarios[2] = new FuncionarioClt("Carlinhos", "222.555.666-80", 600.2, true, 3);
//
//        ContratoDeTrabalho[] contratos = new ContratoDeTrabalho[3];
//
//        Holerite[] holerites = new Holerite[3];
//
//        for (int i = 0; i < funcionarios.length; i++) {
//            System.out.printf("Digite o valor da hora extra e quantidade de horas para o %s%n", funcionarios[i].getNome());
//            contratos[i] = new ContratoDeTrabalho(funcionarios[i], s.nextDouble(), s.nextInt());
//        }
//
//        for (int i = 0; i < holerites.length; i++){
//                holerites[i] = new Holerite(contratos[i]);
//                holerites[i].imprimirHolerite();
//        }

        FuncionarioPj f = new FuncionarioPj("teste", "a", 160, 150, true);

        double salario = f.calcularSalario();
        double desconto = f.calcularISS(salario);


        System.out.println("Salario bruto: "+salario);
        System.out.println(desconto);


        double salrioLiquido = salario - desconto;
        System.out.println("Salario liquido: " + salrioLiquido);
        
    }

}