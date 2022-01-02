package br.com.techdive.ferias.projeto1.manuprinj.utils;


public class TelefoneUtils {

    public static boolean isTelefoneValido(String matricula) {

        if (matricula.length() != 11) return false;

        return true;
    }

    public static String getMascaraTelefone(String telefone) {
        return "(" + telefone.substring(0, 2) + ")" +  telefone.substring(2, 7)  + "-" + telefone.substring(7);
    }
}
