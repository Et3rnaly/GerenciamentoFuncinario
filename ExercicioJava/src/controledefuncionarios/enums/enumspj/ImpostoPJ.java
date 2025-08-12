package controledefuncionarios.enums.enumspj;

public enum ImpostoPJ {
    ISS(3.0); // 3%

    private final double aliquota;

    ImpostoPJ(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getAliquota() {
        return aliquota;
    }
}

