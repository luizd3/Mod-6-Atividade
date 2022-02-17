import db.PresencasDB;
import nomes.AlunoPresenca;
import nomes.Alunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Alunos listaDeAlunos = new Alunos();
    static PresencasDB presencasDB = new PresencasDB();

    public static void main(String[] args) throws Exception {

        int opcao = 0;
        do {
            System.out.println("1 - Registrar novo Aluno");
            System.out.println("2 - Registrar chamada");
            System.out.println("3 - Exibir presenças em lista");
            System.out.println("4 - Exibir diário de classe em tabela");
            System.out.println("5 - Exibir lista de alunos cadastrados");
            System.out.println("6 - Para teste - Preencher 3 nomes automaticamente");
            System.out.println("0 - Sair");
            System.out.print("O que deseja fazer: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            menu(opcao);

        } while (opcao != 0);
    }

    public static void menu(int opcao) throws Exception {

        Scanner scanner = new Scanner(System.in);

        switch (opcao) {
            case 1 : { // Cadastrar novo aluno
                System.out.print("Digite o nome do novo aluno: ");
                String nome = scanner.nextLine();
                listaDeAlunos.addNovoAluno(nome);
                break;
            }
            case 2 : { // Registrar chamada
                System.out.print("Digite a data da chamada: ");
                String data = scanner.next();

                List<AlunoPresenca> presencas = new ArrayList<>();

                for (String nome : listaDeAlunos.getListaAlunos()) {
                    System.out.print(nome + " está presente? s/n: ");
                    String presenca = scanner.next();
                    AlunoPresenca alunoPresenca = new AlunoPresenca(nome, presenca);
                    presencas.add(alunoPresenca);
                }

                presencasDB.addNovaChamada(data, presencas);
                System.out.println("Chamada do dia " + data + " registrada com sucesso.");
                break;
            }
            case 3 : { // Exibir presenças em lista
                System.out.println("Lista das Presenças Registradas:");

                for (String data : presencasDB.getDiarioClasse().keySet()) {
                    System.out.println("Data: " + data);

                    List<AlunoPresenca> presencas = presencasDB.getDiarioClasse().get(data);

                    for (AlunoPresenca aluno : presencas) {
                        System.out.print(aluno.getNome() + ": " + aluno.getPresente() + " | ");
                    }
                    System.out.println("");
                    System.out.println("---------------------------------------");
                }
                break;
            }
            case 5 : { // Exibir lista de alunos
                System.out.println("-- Lista de Alunos Cadastrados:");
                System.out.println(listaDeAlunos.getListaAlunos());
                break;
            }
            case 6 : { // Para teste - Preencher 3 nomes automaticamente
                listaDeAlunos.addNovoAluno("João");
                listaDeAlunos.addNovoAluno("José");
                listaDeAlunos.addNovoAluno("Maria");
                break;
            }

            case 0 : {
                System.out.println("Sistema encerrado.");
                break;
            }
            default:{
                System.out.println("Opção Inválida");
                break;
            }
            }
        }
    }

