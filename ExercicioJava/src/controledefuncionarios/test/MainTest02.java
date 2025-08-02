package controledefuncionarios.test;

import controledefuncionarios.domain.FuncionarioPj;

import java.util.Scanner;

public class MainTest02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FuncionarioPj funcionarioPj = new FuncionarioPj("Nome", "11.111.111/0001-11", 1000);

        funcionarioPj.bonusPorProjetosEntregues(3);

        double aplicaBonus = funcionarioPj.getBonusPorEntrega() * funcionarioPj.getSalarioBase();
        double salarioFinal = funcionarioPj.getSalarioBase() + aplicaBonus;

        System.out.println(salarioFinal);

    }

}
