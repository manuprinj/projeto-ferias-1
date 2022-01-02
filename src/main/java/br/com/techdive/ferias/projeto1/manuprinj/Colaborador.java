package br.com.techdive.ferias.projeto1.manuprinj;


import static br.com.techdive.ferias.projeto1.manuprinj.Main.menu;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.CpfUtils.getMascaraCPF;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getData;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getInt;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getString;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.MatriculaUtils.getMascaraMatricula;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.TelefoneUtils.getMascaraTelefone;

import java.time.LocalDate;
import java.util.StringJoiner;

import br.com.techdive.ferias.projeto1.manuprinj.types.StatusColaborador;
import br.com.techdive.ferias.projeto1.manuprinj.utils.DataUtils;


public class Colaborador {

    private String nome;
    private String cpf;
    private String matricula;
    private String telefone;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;

    public Colaborador(String nome, String cpf, String matricula, String telefone, LocalDate dataAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
    }

    public void alterarDadosCadastrais() {
        System.out.println("Qual dado você deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Telefone");
        int opcao = getInt();

        if (opcao < 1 || opcao > 2) {
            System.out.println("Digite uma opção válida!!");
            alterarDadosCadastrais();
        } else if (opcao == 1) {
            System.out.println("Seu nome atual é: " + getNome());
            String nomeNovo = getString("Digite o novo nome:");

            setNome(nomeNovo);
        }else {
            System.out.println("Seu telefone atual é: " + getTelefone());
            String telefoneNovo = getString("Digite seu novo telefone: ");

            setTelefone(telefoneNovo);
        }
    }
        public void demitir () {
            System.out.println("Você tem certeza que deseja demitir o(a) : " + getNome() + "?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int opcao = getInt();

            if (opcao < 1 || opcao > 2) {
                System.out.println("Digite uma opção válida!!");
                demitir();
            } else if (opcao == 1) {
                LocalDate dataDemissao = getData("Digite a data de demissão do funcionário (dd/MM/yyyy): ");
                setDataDemissao(dataDemissao);
            } else {
                menu();
            }
        }

        @Override public String toString () {
            StringJoiner joiner = new StringJoiner(" | ").add("Status: " + getStatus())
                    .add("Matricula: " + getMascaraMatricula(getMatricula())).add("Nome: " + getNome())
                    .add("CPF: " + getMascaraCPF(getCpf())).add("Telefone: " + getMascaraTelefone(getTelefone()))
                    .add("Data de Admissão: " + DataUtils.format(getDataAdmissao()));

            return joiner.toString();
        }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public String getCpf () {
            return cpf;
        }

        public String getMatricula () {
            return matricula;
        }

        public String getTelefone () {
            return telefone;
        }

        public void setTelefone (String telefone){
            this.telefone = telefone;
        }

        public StatusColaborador getStatus () {
            if (dataDemissao != null) return StatusColaborador.INATIVO;
            return StatusColaborador.ATIVO;
        }

        public LocalDate getDataAdmissao () {
            return dataAdmissao;
        }

        public void setDataAdmissao (LocalDate dataAdmissao){
            this.dataAdmissao = dataAdmissao;
        }

        public LocalDate getDataDemissao () {
            return dataDemissao;
        }

        public void setDataDemissao (LocalDate dataDemissao){
            this.dataDemissao = dataDemissao;
        }
    }
