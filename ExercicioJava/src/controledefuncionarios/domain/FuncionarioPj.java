package controledefuncionarios.domain;

import controledefuncionarios.enums.enumspj.BonusRelacionado;
import controledefuncionarios.interfaces.DescontosPj;

public class FuncionarioPj extends Funcionario implements DescontosPj {

    private String nomePrestador;
    private String cnpj;
    private double valorHora;
    private int horasTrabalhadas;
    private boolean isBonus;
    private double bonus;

    public FuncionarioPj(String nomePrestador, String cnpj, double valorHora, int horasTrabalhadas, boolean bonus) {
        super(nomePrestador, null, valorHora);
        this.horasTrabalhadas = horasTrabalhadas;
        this.isBonus = bonus;
        this.valorHora = valorHora;
        this.cnpj = cnpj;
        this.nomePrestador = nomePrestador;
    }

    @Override
    public double calcularISS(double valorServico) {
        return DescontosPj.super.calcularISS(valorServico);
    }

    public double aplicarBonus(int projetosEntregues) {
        if (!isBonus || projetosEntregues <= 0) {
            bonus = 0;
            return bonus;
        }

        if (projetosEntregues <= 2) {
            bonus = BonusRelacionado.BONUS_DEFAUT.getBonus() * calcularSalario();
        } else if (projetosEntregues <= 5) {
            bonus = BonusRelacionado.BONUS_MEDIO.getBonus() * calcularSalario();
        } else {
            bonus = BonusRelacionado.BONUS_MAXIMO.getBonus() * calcularSalario();
        }

        return bonus;
    }

    @Override
    public double calcularSalario() {
        double salarioBruto = this.valorHora * this.horasTrabalhadas;
        double desconto = calcularISS(salarioBruto);
        double salarioLiquidoFinal = salarioBruto - desconto + bonus;

        return salarioLiquidoFinal;
    }


    @Override
    public void exbirDados() {
        System.out.println("--- Dados Prestador ---");
            System.out.println("Prestador: " + nomePrestador);
            System.out.println("CNPJ: " + cnpj);
            System.out.println("===================");
        }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomePrestador() {
        return nomePrestador;
    }

    public double getValorHora() {
        return valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getBonus() {
        return bonus;
    }
}


