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
        super(nomePrestador, cnpj, valorHora);
        this.horasTrabalhadas = horasTrabalhadas;
        this.isBonus = bonus;
    }

    public double aplicarBonus(int projetosEntregues) {
        if (projetosEntregues <= 0) return 0;

        if (projetosEntregues <= 2) {
            bonus = BonusRelacionado.BONUS_DEFAUT.getBonus() * getSalarioBase();
        } else if (projetosEntregues <= 5) {
            bonus = BonusRelacionado.BONUS_MEDIO.getBonus() * getSalarioBase();
        } else {
            bonus = BonusRelacionado.BONUS_MAXIMO.getBonus() * getSalarioBase();
        }

        return bonus;
    }

    @Override
    public double calcularISS(double valorServico) {
        return DescontosPj.super.calcularISS(valorServico);
    }

    @Override
    public double calcularSalario() {
        return (valorHora * horasTrabalhadas) + bonus;
    }

    public double calcularSalarioLiquido(){
        double salarioBruto = calcularSalario();
        double desconto = calcularISS(salarioBruto);
        
        return salarioBruto - desconto;
    }

    @Override
    public void exbirDados() {
        System.out.println("--- Contrato PJ ---");
            System.out.println("Prestador: " + nomePrestador);
            System.out.println("CNPJ: " + cnpj);
            System.out.println("Valor por Hora: R$" + valorHora);
            System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
            System.out.println("Bônus: R$" + bonus);
            System.out.println("Pagamento Total: R$" + calcularSalario());
        }
}

