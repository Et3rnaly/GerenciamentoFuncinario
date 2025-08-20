package controledefuncionarios.utils;

public class CPFUtil {
    public static boolean isValidCpf(String cpf) {
        String numberCPF = cpf.replaceAll("[^0-9]", "");

        if (numberCPF == null || numberCPF.length() != 11) {
            return false;
        }


        int[] weightsDV1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsDV2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < numberCPF.length() - 2; i++) {
            char numsCPF = numberCPF.charAt(i);
            soma += ((int) numsCPF - (int) '0') * weightsDV1[i];
        }

        int resto = soma % 11;

        int dv = 11 - resto;

        if (dv > 9) dv = 0;

        if (!(dv == numberCPF.charAt(9) - (int) '0')) {
            System.err.println("CPF INVALIDO");
            return false;
        }


        soma = 0;
        for (int i = 0; i < numberCPF.length() -1; i++) {
            char numsCPF = numberCPF.charAt(i);
            soma += ((int) numsCPF - (int) '0') * weightsDV2[i];
        }

        resto = soma % 11;

        int dv2 = 11 - resto;

        if (dv2 > 9) dv2 = 0;

        if (dv2 == numberCPF.charAt(10) - (int) '0') {
            System.out.println("cpf valido");
            return true;
        } else {
            System.err.println("CPF INVALIDO");
            return false;
        }

    }

    public static String formatarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return cpf;
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
