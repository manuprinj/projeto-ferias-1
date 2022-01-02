package br.com.techdive.ferias.projeto1.manuprinj.utils;


public class MatriculaUtils {

    public static boolean isMatriculaValida(String matricula) {

        if (matricula.length() != 5) return false;

        return true;
    }

    public static String getMascaraMatricula(String matricula) {
        return matricula.substring(0, 4) + "-" + matricula.substring(4);
    }
}
