package controledefuncionarios.domain;

public class FuncionarioPj extends Funcionario {
    private int horasTrabalhadas;
    private double bonusPorEntrega;
    private int tempoDoContrato;
    private double remuneracaoContratual;
    private int quantidadeDeProjetosEntreguado;
    private String cnpj;

    public FuncionarioPj(String nome, String cnpj, double salarioBase) {
        super(nome, cnpj, salarioBase);
    }

    public double bonusPorProjetosEntregues(int quantidadeDeProjetosEntreguado) {
        this.quantidadeDeProjetosEntreguado = quantidadeDeProjetosEntreguado;

        if (quantidadeDeProjetosEntreguado < 2) {
            return bonusPorEntrega = 0.05;
        } else if (quantidadeDeProjetosEntreguado < 5) {
            return bonusPorEntrega = 0.10;
        } else {
            return bonusPorEntrega = 0.15;
        }

    }


    @Override
    public double calcularSalario() {
        return horasTrabalhadas * contrato.getValorHora();
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getTempoDoContrato() {
        return tempoDoContrato;
    }

    public void setTempoDoContrato(int tempoDoContrato) {
        this.tempoDoContrato = tempoDoContrato;
    }

    public double getRemuneracaoContratual() {
        return remuneracaoContratual;
    }

    public void setRemuneracaoContratual(double remuneracaoContratual) {
        this.remuneracaoContratual = remuneracaoContratual;
    }

    public double getBonusPorEntrega() {
        return bonusPorEntrega;
    }

    public void setBonusPorEntrega(double bonusPorEntrega) {
        this.bonusPorEntrega = bonusPorEntrega;
    }
}

