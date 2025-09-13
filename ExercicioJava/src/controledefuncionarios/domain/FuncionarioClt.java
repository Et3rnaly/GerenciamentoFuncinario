package controledefuncionarios.domain;

import controledefuncionarios.enums.FaixaSalario;

public class FuncionarioClt extends Funcionario implements Comparable<Funcionario> {
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

    public double aplicarBeneficio() {
       return beneficios = valeTranposte;
    }

    public double desconto() {
        FaixaSalario faixa = FaixaSalario.porSalario(getSalarioBase());
        return descontos = faixa.getFaixaINSS().calcularDesconto(getSalarioBase());
    }

    public double dercimoTerceiro() {
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
    public void exbirDados() {
        System.out.println("\n--- Dados CLT ---");
        System.out.println("\nNome: " + getNome());
        System.out.println("Cpf: " + getDocumento());
        System.out.println("Tem beneficio: " + temBeneficos);
        System.out.println("Tempo de empresa: " + tempoDeEmpresaEmMeses);
        System.out.println("=======================");
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

    public double getDescontos() {
        return descontos;
    }

    @Override
    public int compareTo(Funcionario o) {
        return this.getDocumento().compareTo(o.getDocumento());
    }
}
