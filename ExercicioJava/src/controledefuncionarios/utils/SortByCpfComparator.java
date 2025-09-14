package controledefuncionarios.utils;

import controledefuncionarios.domain.Funcionario;

import java.util.Comparator;

public class SortByCpfComparator implements Comparator<Funcionario> {
    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        return o1.getDocumento().compareTo(o2.getDocumento());
    }
}
