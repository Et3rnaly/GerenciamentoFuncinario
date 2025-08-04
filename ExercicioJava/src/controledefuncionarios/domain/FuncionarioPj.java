package controledefuncionarios.domain;

import controledefuncionarios.enums.enumspj.BonusRelacionado;

public class FuncionarioPj extends Funcionario {

    private int horasTrabalhadas;
    private boolean possuiBonus;
    private int projetosEntregues;
    private double salarioFinal;
    private String cnpj;

    public FuncionarioPj(String nome, String cpf,String cnpj ,double salarioBase, int entrega) {
        super(nome, cpf, salarioBase);
        this.projetosEntregues = entrega;
        this.cnpj = cnpj;
    }

    public double aplicarBonus() {
        if (projetosEntregues <= 0) return 0;

        if (projetosEntregues <= 2) {
            return BonusRelacionado.BONUS_DEFAUT.getBonus() * getSalarioBase();
        } else if (projetosEntregues <= 5) {
            return BonusRelacionado.BONUS_MEDIO.getBonus() * getSalarioBase();
        } else {
            return BonusRelacionado.BONUS_MAXIMO.getBonus() * getSalarioBase();
        }
    }

@Override
public double calcularSalario() {
    salarioFinal = getSalarioBase();

    double bonus = aplicarBonus();

    salarioFinal += bonus;


    return salarioFinal;
}

    @Override
    public void exbirDados() {
        System.out.println("--- Funcionario PJ ---");
        System.out.println("\nNome: " + getNome());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Cnpj: " + cnpj);
        System.out.println("=======================");
    }

    @Override
public String toString() {
    return "FuncionarioPj{" +
            "horasTrabalhadas=" + horasTrabalhadas +
            ", possuiBonus=" + possuiBonus +
            ", projetosEntregues=" + projetosEntregues +
            ", salarioFinal=" + salarioFinal +
            '}';
}
}

