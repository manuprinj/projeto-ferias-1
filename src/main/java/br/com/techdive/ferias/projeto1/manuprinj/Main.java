package br.com.techdive.ferias.projeto1.manuprinj;


import static br.com.techdive.ferias.projeto1.manuprinj.Listas.listarTodosColaboradores;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getCPF;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getInt;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getMatricula;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getString;
import static br.com.techdive.ferias.projeto1.manuprinj.utils.EntradasUtils.getTelefone;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static int totalFuncionario=0;
    public static List<Colaborador> colaboradores = new ArrayList<>();

    public static void menu() {
        System.out.println("Seja bem-vindo ao Sistema Gerencial TechDive");
        System.out.println("1 - Adicionar Funcionário");
        System.out.println("2 - Ver detalhes de um funcionário");
        System.out.println("3 - Demitir funcionário");
        System.out.println("4 - Atualizar informações de um funcionário");
        System.out.println("5 - Listar todos os funcionários");
        System.out.println("6 - Listar somente os funcionários trabalhando");
        System.out.println("7 - Listar somente os funcionários demitidos");
        System.out.println("8 - Sair");
        int tipoOperacao = getInt();

        if (tipoOperacao < 1 || tipoOperacao > 8) {
            System.out.println("Digite uma opção válida!!");
            return;
        }
        if (tipoOperacao == 1) adicionarFuncionario();
        if (tipoOperacao == 2) detalhesColaborador();
        if (tipoOperacao == 3) ;
        if (tipoOperacao == 4) atualizarInformacoes();
        if (tipoOperacao == 5) listarTodosColaboradores();
        if (tipoOperacao == 6) ;
        if (tipoOperacao == 7) ;
        if (tipoOperacao == 8) ;
    }

    public static void adicionarFuncionario() {
        System.out.println("Selecione um dos cargos abaixo: ");
        System.out.println("1 - Colaborador");
        System.out.println("2 - Líder Técnico");
        System.out.println("3 - Gerente de Departamento");
        int cargoFuncionario = getInt();

        if (cargoFuncionario < 1 || cargoFuncionario > 3) {
            System.out.println("Digite uma opção válida!!");
            adicionarFuncionario();
        } else {

            String matricula = getMatricula("Digite a matrícula (5 números): ");

            String nome = getString("Digite o nome do funcionário:");

            String cpf = getCPF("Digite o CPF do funcionário:");

            String telefone = getTelefone("Digite o telefone celular do funcionário (Apenas números): ");

            if (cargoFuncionario == 1) {
                Colaborador colaborador = new Colaborador(nome, cpf, matricula, telefone);
                colaboradores.add(colaborador);
            }

            if (cargoFuncionario == 2) {
                LiderTecnico colaborador = new LiderTecnico(nome, cpf, matricula, telefone);
                colaboradores.add(colaborador);
            }

            if (cargoFuncionario == 3) {
                GerenteDepartamento colaborador = new GerenteDepartamento(nome, cpf, matricula, telefone);
                colaboradores.add(colaborador);
            }
            totalFuncionario++;
        }
    }

    public static Colaborador validacaoColaborador() {
        String numMatricula = getString("Digite o número da matrícula: ");

        for (Colaborador colaborador : colaboradores) {
            if(colaborador.getMatricula().equals(numMatricula)) return colaborador;
        }

        System.out.println("Colaborador não encontrado!");
        return null;
    }

    public static void detalhesColaborador() {
        Colaborador colaborador = validacaoColaborador();
        if (colaborador == null) return;

        if (!(colaborador instanceof GerenteDepartamento)
                && !(colaborador instanceof GerenteGeral)
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

    public static void atualizarInformacoes() {
        Colaborador colaborador = validacaoColaborador();
        if (colaborador != null) colaborador.alterarDadosCadastrais();
    }

    public static void main(String[] args) {
        while (true){
            menu();
        }
    }
}
