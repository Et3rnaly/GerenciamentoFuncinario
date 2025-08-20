package controledefuncionarios.domain;

import controledefuncionarios.enums.TipoFuncionario;
import controledefuncionarios.exceptions.IllegalSalaryArgumentException;
import controledefuncionarios.exceptions.InvalidOperationTipeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salarioBase;
    ContratoDeTrabalho contrato;

    public Funcionario(String nome, String cpf, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }

    public static boolean isValidSalario(Double salario){
        if (salario == null || salario < 0){
            throw new IllegalSalaryArgumentException("Salario invalido seu salario não pode ser negativo. Operação cancelada.");
        }
        return true;
    }

    public static boolean isValidTipe(String tipe) {
        try {
            TipoFuncionario.valueOf(tipe.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            throw new InvalidOperationTipeException("Tipo de funcionario invalido, informe um valor valido 'clt' ou 'pj'. Operação cancelada.");
        }
    }

    public abstract void exbirDados();

    public abstract double calcularSalario();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
