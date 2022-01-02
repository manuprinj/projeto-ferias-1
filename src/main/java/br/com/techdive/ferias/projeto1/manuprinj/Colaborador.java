package br.com.techdive.ferias.projeto1.manuprinj;


import static br.com.techdive.ferias.projeto1.manuprinj.utils.CpfUtils.getMascaraCPF;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getInt;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getString;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.MatriculaUtils.getMascaraMatricula;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.TelefoneUtils.getMascaraTelefone;

import java.util.Scanner;
import java.util.StringJoiner;

import br.com.techdive.ferias.projeto1.manuprinj.types.StatusColaborador;


public class Colaborador {

    private String nome;
    private String cpf;
    private String matricula;
    private String telefone;
    private StatusColaborador status;

    public Colaborador(String nome, String cpf, String matricula, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.telefone = telefone;
    }

    Scanner sc = new Scanner(System.in);

    public void alterarDadosCadastrais() {
        System.out.println("Qual dado você deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Telefone");
        int opcao = getInt();

        if (opcao == 1) {
            System.out.println("Seu nome atual é: " + getNome());
            String nomeNovo = getString("Digite o novo nome:");

            setNome(nomeNovo);
        }

        if (opcao == 2) {
            System.out.println("Seu telefone atual é: " + getTelefone());
            String telefoneNovo = getString("Digite seu novo telefone: ");

            setTelefone(telefoneNovo);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("Status: " + getStatus())
                .add("Matricula: " + getMascaraMatricula(getMatricula()))
                .add("Nome: " + getNome())
                .add("CPF: " + getMascaraCPF(getCpf()))
                .add("Telefone: " + getMascaraTelefone(getTelefone()));

        return joiner.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusColaborador getStatus() {
        return status;
    }
}
