package controledefuncionarios.domain;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Holerite {
    ContratoDeTrabalho contrato;
    Locale localeBrazil = Locale.of("pt", "BR");
    LocalDate mes = LocalDate.now();
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeBrazil);

    public Holerite(ContratoDeTrabalho contrato) {
        this.contrato = contrato;
    }

    public void imprimirHolerite() {
        System.out.println("===== HOLERITE =====");
//
        if (contrato.getFuncionario() instanceof FuncionarioClt clt) {

            System.out.println("Funcionario: " + clt.getNome());
            System.out.println("CPF: " + clt.getCpf());

            clt.aplicarBeneficio();
            System.out.println("Valor do benefio: " + numberFormat.format(clt.getBeneficios()));

            clt.desconto();
            System.out.println("Desconto INSS: " + numberFormat.format(clt.getDescontos()));

            System.out.println("Salario bruto: " + numberFormat.format(clt.getSalarioBase()));
            System.out.println("Horas extras: " + contrato.getHorasExtras());
            System.out.println("Salario liquido final: " + numberFormat.format(contrato.calcularSalarioFinal()));

            System.out.println("Data de impresão: " + mes);
            System.out.println("====================");
        }

        if (contrato.getFuncionario() instanceof FuncionarioPj pj) {

            System.out.println("Nome pretador: " + pj.getNomePrestador());
            System.out.println("CNPJ: " + pj.getCnpj());
            System.out.println("Valor da hora: " + numberFormat.format(pj.getValorHora()));
            System.out.println("Horas trabalhadas: " + pj.getHorasTrabalhadas());

            System.out.println("Bonus por entregas: " + numberFormat.format(pj.getBonus()));
            System.out.println("Desconto ISS: " + numberFormat.format(pj.calcularISS(pj.calcularSalario())));

            System.out.println("Horas extras: " + contrato.getHorasExtras());
            System.out.println("Valor Horas extras: " + numberFormat.format(contrato.getValorHora()));


            System.out.println("Salario bruto: " + numberFormat.format(pj.calcularSalario()));
            System.out.println("Salario liquido final: " + numberFormat.format(contrato.calcularSalarioFinal()));

            System.out.println("Data de impresão: " + mes);
            System.out.println("====================");
        }

    }

}
