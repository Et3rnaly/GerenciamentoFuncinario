package controledefuncionarios.enums;

public enum FaixaSalario {
    SALARIO_MINIMO(1518.0, FaixaINSS.FAIXA0),
    SALARIO_MEDIO(2793.88, FaixaINSS.FAIXA1),
    SALARIO_CLASSE_MEDIA(4190.83, FaixaINSS.FAIXA2),
    SALARIO_CLASSE_ALTA(Double.MAX_VALUE, FaixaINSS.FAIXA3);
    FaixaINSS faixaINSS;

    public final double SALARIO_LIMITE;

    FaixaSalario(double salarioLimite, FaixaINSS faixaINSS) {
        this.SALARIO_LIMITE = salarioLimite;
        this.faixaINSS = faixaINSS;
    }

    public static FaixaSalario porSalario(double salario) {
        for (FaixaSalario faixa : values()) {
            if (salario <= faixa.getSALARIO_LIMITE()){
                return faixa;
            }
        }
        return SALARIO_CLASSE_ALTA;
    }

    public double getSALARIO_LIMITE() {
        return SALARIO_LIMITE;
    }

    public FaixaINSS getFaixaINSS() {
        return faixaINSS;
    }
}
