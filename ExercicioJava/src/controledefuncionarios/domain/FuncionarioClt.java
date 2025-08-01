package controledefuncionarios.domain;

import controledefuncionarios.enums.FaixaSalario;

public class FuncionarioClt extends Funcionario {

    private double beneficios;
    private double descontos;
    private boolean temBeneficos;
    private int tempoDeEmpresaEmMeses;
    private double salarioFinal;

    private double valeTranposte = 100;

    public FuncionarioClt(String nome, String cpf, double salarioBase, boolean temBeneficos, int tempoDeEmpresaEmMeses) {
        super(nome, cpf, salarioBase);
        this.temBeneficos = temBeneficos;
        this.tempoDeEmpresaEmMeses = tempoDeEmpresaEmMeses;
    }

    private boolean temBeneficio() {
        return temBeneficos;
    }

    private double aplicarBeneficio() {
       return beneficios = valeTranposte;
    }

    private double desconto() {
        FaixaSalario faixa = FaixaSalario.porSalario(getSalarioBase());
        return descontos = faixa.getFaixaINSS().calcularDesconto(getSalarioBase());
    }

    private double dercimoTerceiro() {
        return getSalarioBase() / 12 * tempoDeEmpresaEmMeses;
    }

    @Override
    public double calcularSalario() {
        salarioFinal = getSalarioBase();

        double valorDesconto = desconto();

        if (temBeneficos){
            salarioFinal += aplicarBeneficio();
        }

        salarioFinal -= valorDesconto;

        if (tempoDeEmpresaEmMeses >= 12){
            salarioFinal += dercimoTerceiro();
        }

        return salarioFinal;
    }

    @Override
    public String toString() {
        return "FuncionarioClt{" +
                "beneficios=" + beneficios +
                ", descontos=" + descontos +
                ", temBeneficos=" + temBeneficos +
                ", tempoDeEmpresaEmMeses=" + tempoDeEmpresaEmMeses +
                ", salarioFinal=" + salarioFinal +
                ", valeTranposte=" + valeTranposte +
                '}';
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public boolean isTemBeneficos() {
        return temBeneficos;
    }

    public void setTemBeneficos(boolean temBeneficos) {
        this.temBeneficos = temBeneficos;
    }

    public int getTempoDeEmpresaEmMeses() {
        return tempoDeEmpresaEmMeses;
    }

    public void setTempoDeEmpresaEmMeses(int tempoDeEmpresaEmMeses) {
        this.tempoDeEmpresaEmMeses = tempoDeEmpresaEmMeses;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public double getValeTranposte() {
        return valeTranposte;
    }

    public void setValeTranposte(double valeTranposte) {
        this.valeTranposte = valeTranposte;
    }
}
