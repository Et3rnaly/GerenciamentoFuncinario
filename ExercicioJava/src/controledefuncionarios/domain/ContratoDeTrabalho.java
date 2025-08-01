package controledefuncionarios.domain;

import java.util.IllegalFormatCodePointException;

public class ContratoDeTrabalho {
    private Funcionario funcionario;
    private double valorHoraExtra;
    private int horasExtras;

    public ContratoDeTrabalho(Funcionario funcionario, double valorHoraExtra, int horasExtras) {
        this.funcionario = funcionario;
        this.valorHoraExtra = valorHoraExtra;
        this.horasExtras = horasExtras;
    }

    double calcularSalarioFinal(){
        return (this.horasExtras * this.valorHoraExtra) + funcionario.calcularSalario();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
}
