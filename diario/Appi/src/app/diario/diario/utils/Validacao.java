package app.diario.diario.utils;

import app.diario.diario.model.Departamento;

public class Validacao {

    public static boolean validaNome(String nome) {
        if (nome.length() > 255 || nome.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validaNome(Departamento depto) {
        return validaNome(depto.getNome());
    }
}
