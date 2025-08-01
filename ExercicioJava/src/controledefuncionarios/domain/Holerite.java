package controledefuncionarios.domain;

public class Holerite {
    ContratoDeTrabalho contrato;
    private String mesReferencia;
    public Holerite(ContratoDeTrabalho contrato) {
        this.contrato = contrato;
    }

    public void imprimirHolerite() {
        System.out.println("===== HOLERITE =====");
//        System.out.println("Mês de referência: " + mesReferencia);
        System.out.println("Funcionário: " + contrato.getFuncionario().getNome());
        System.out.println("CPF: " + contrato.getFuncionario().getCpf());
        System.out.printf("Salário base: R$ %.2f%n", contrato.getFuncionario().getSalarioBase());
        System.out.printf("Horas extras: %d%n", contrato.getHorasExtras());
        System.out.printf("Salário líquido final: R$ %.2f%n", contrato.calcularSalarioFinal());
        System.out.println("====================");
    }

}
