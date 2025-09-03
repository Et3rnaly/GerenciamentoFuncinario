package controledefuncionarios.enums.enumspj;

public enum FaixaISS {
    ISS(3.0); // 3%

    private final double aliquota;

    FaixaISS(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getAliquota() {
        return aliquota;
    }
}

