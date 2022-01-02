package br.com.techdive.ferias.projeto1.manuprinj.types;


public enum StatusColaborador {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String status;

    StatusColaborador(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
