package controledefuncionarios.interfaces;

import controledefuncionarios.enums.enumspj.FaixaISS;
import controledefuncionarios.exceptions.IllegalSalaryArgumentException;

public interface DescontosPj {
    default double calcularISS(double valorServico) {
        if (valorServico < 0) {
            throw new IllegalSalaryArgumentException("Valores não podem ser negativo");
        }
        return valorServico * (FaixaISS.ISS.getAliquota() / 100);
    }
}
