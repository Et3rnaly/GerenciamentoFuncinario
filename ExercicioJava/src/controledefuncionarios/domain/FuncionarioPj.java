package controledefuncionarios.domain;

public class FuncionarioPj extends Funcionario{
    private int horasTrabalhadas;
    private int projetosEntregues;
    private int tempoDoContrato;
    private String cnpj;

    public FuncionarioPj(String nome, String cnpj, double salarioBase) {
        super(nome, cnpj, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return 0;
    }

}
