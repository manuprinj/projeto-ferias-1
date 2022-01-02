package br.com.techdive.ferias.projeto1.manuprinj;


import static br.com.techdive.ferias.projeto1.manuprinj.Listas.listarTodosColaboradores;
import static br.com.techdive.ferias.projeto1.manuprinj.Listas.listarTodosColaboradoresAtivos;
import static br.com.techdive.ferias.projeto1.manuprinj.Listas.listarTodosColaboradoresIntivos;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getCPF;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getData;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getInt;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getMatricula;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getString;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getTelefone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static List<Colaborador> colaboradores = new ArrayList<>();

    public static void menu() {
        int tipoOperacao = 0;
        while (tipoOperacao != 8) {
            System.out.println("Seja bem-vindo ao Sistema Gerencial TechDive");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Ver detalhes de um funcionário");
            System.out.println("3 - Demitir funcionário");
            System.out.println("4 - Atualizar informações de um funcionário");
            System.out.println("5 - Listar todos os funcionários");
            System.out.println("6 - Listar somente os funcionários trabalhando");
            System.out.println("7 - Listar somente os funcionários demitidos");
            System.out.println("8 - Sair");
            tipoOperacao = getInt();

            if (tipoOperacao < 1 || tipoOperacao > 8) {
                System.out.println("Digite uma opção válida!!");
                return;
            }
            if (tipoOperacao == 1) adicionarFuncionario();
            if (tipoOperacao == 2) detalhesColaborador();
            if (tipoOperacao == 3) demitirFuncionario();
            if (tipoOperacao == 4) atualizarInformacoes();
            if (tipoOperacao == 5) listarTodosColaboradores();
            if (tipoOperacao == 6) listarTodosColaboradoresAtivos();
            if (tipoOperacao == 7) listarTodosColaboradoresIntivos();
        }
    }

    public static void adicionarFuncionario() {
        System.out.println("Selecione um dos cargos abaixo: ");
        System.out.println("1 - Colaborador");
        System.out.println("2 - Líder Técnico");
        System.out.println("3 - Gerente de Departamento");
        System.out.println("4 - Gerente Geral");
        int cargoFuncionario = getInt();

        if (cargoFuncionario < 1 || cargoFuncionario > 4) {
            System.out.println("Digite uma opção válida!!");
            adicionarFuncionario();
        } else {

            String matricula = getMatricula("Digite a matrícula (5 números): ");

            String nome = getString("Digite o nome do funcionário:");

            String cpf = getCPF("Digite o CPF do funcionário:");

            String telefone = getTelefone("Digite o telefone celular do funcionário (Apenas números): ");

            LocalDate dataAdmissao = getData("Digite a data de admissão do funcionário (dd/MM/yyyy): ");

            if (cargoFuncionario == 1) {
                Colaborador colaborador = new Colaborador(nome, cpf, matricula, telefone, dataAdmissao);
                colaboradores.add(colaborador);
            }

            if (cargoFuncionario == 2) {
                LiderTecnico colaborador = new LiderTecnico(nome, cpf, matricula, telefone, dataAdmissao);
                colaboradores.add(colaborador);
            }

            if (cargoFuncionario == 3) {
                GerenteDepartamento colaborador = new GerenteDepartamento(nome, cpf, matricula, telefone, dataAdmissao);
                colaboradores.add(colaborador);
            }

            if (cargoFuncionario == 4) {
                GerenteGeral colaborador = new GerenteGeral(nome, cpf, matricula, telefone, dataAdmissao);
                colaboradores.add(colaborador);
            }
        }
    }

    public static Colaborador validacaoColaborador() {
        String numMatricula = getString("Digite o número da sua matrícula: ");

        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getMatricula().equals(numMatricula)) return colaborador;
        }

        System.out.println("Colaborador não encontrado!");
        return null;
    }

    public static void detalhesColaborador() {
        Colaborador colaborador = validacaoColaborador();
        if (colaborador == null) return;

        if (!(colaborador instanceof GerenteDepartamento) && !(colaborador instanceof GerenteGeral)
                && !(colaborador instanceof LiderTecnico)) {
            System.out.println("Sem permissão!!");
            return;
        } else {
            String matriculaFuncionario = getString("Digite a matrícula do funcionário: ");
            for (Colaborador colaborador1 : colaboradores) {
                if (colaborador1.getMatricula().equals(matriculaFuncionario)) {
                    System.out.println(colaborador1);
                }
            }
        }
    }

    public static void demitirFuncionario() {
        Colaborador colaborador = validacaoColaborador();
        if (colaborador == null) return;

        if (!(colaborador instanceof GerenteGeral)) {
            System.out.println("Sem permissão!!");
            return;
        } else {
            String matriculaFuncionario = getString("Digite a matrícula do funcionário: ");
            for (Colaborador colaborador1 : colaboradores) {
                if (colaborador1.getMatricula().equals(matriculaFuncionario)) {
                    colaborador1.demitir();
                }
            }
        }
    }

    public static void atualizarInformacoes() {
        Colaborador colaborador = validacaoColaborador();
        if (colaborador == null) return;

        if (!(colaborador instanceof GerenteDepartamento) && !(colaborador instanceof GerenteGeral)
                && !(colaborador instanceof LiderTecnico)) {
            System.out.println("Sem permissão!!");
            return;
        } else {
            String matriculaFuncionario = getString("Digite a matrícula do funcionário: ");
            for (Colaborador colaborador1 : colaboradores) {
                if (colaborador1.getMatricula().equals(matriculaFuncionario)) {
                    colaborador1.alterarDadosCadastrais();
                }
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
