package controledefuncionarios.enums.enumspj;

public enum BonusRelacionado {
    BONUS_DEFAUT(0.05),
    BONUS_MEDIO(0.10),
    BONUS_MAXIMO(Double.MAX_VALUE);

    private double bonus;

    BonusRelacionado(double bonus) {
        this.bonus = bonus;

    }

    public double getBonus() {
        return bonus;
    }
}
