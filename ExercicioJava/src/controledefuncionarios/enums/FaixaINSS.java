package controledefuncionarios.enums;

public enum FaixaINSS {
    FAIXA0(0.075, 0),
    FAIXA1(0.09, 22.77),
    FAIXA2(0.12, 106.59),
    FAIXA3(0.14, 190.40);


    private double aliquota;
    private double descontoFixo;

    FaixaINSS(double aliquota, double descontoFixo) {
        this.aliquota = aliquota;
        this.descontoFixo = descontoFixo;
    }

    public double calcularDesconto(double salarioBase){
        return (salarioBase * aliquota) - descontoFixo;
    }

    public double getAliquota() {
        return aliquota;
    }

    public double getDescontoFixo() {
        return descontoFixo;
    }
}
