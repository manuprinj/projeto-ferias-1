package br.com.techdive.ferias.projeto1.manuprinj;


import br.com.techdive.ferias.projeto1.manuprinj.types.StatusColaborador;


public class Listas {

    public static void listarTodosColaboradores() {
        for (Colaborador colaboradores : Main.colaboradores) {
                System.out.println(colaboradores);
        }
    }

    public static void listarTodosColaboradoresAtivos() {
        for (Colaborador colaboradores : Main.colaboradores) {
            if (colaboradores.getStatus() == StatusColaborador.ATIVO){
                System.out.println(colaboradores);
            }
        }
    }

    public static void listarTodosColaboradoresIntivos() {
        for (Colaborador colaboradores : Main.colaboradores) {
            if (colaboradores.getStatus() == StatusColaborador.INATIVO){
                System.out.println(colaboradores);
            }
        }
    }
}
