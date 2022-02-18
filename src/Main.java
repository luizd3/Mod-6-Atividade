import db.PresencasDB;
import nomes.AlunoPresenca;
import nomes.Alunos;

import java.util.*;

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
            System.out.println("6 - Para teste - Preencher 3 chamadas automaticamente");
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
                if (listaDeAlunos.getListaAlunos().isEmpty()) {
                    System.out.println("Lista de Alunos está vazia. Cadastre alunos.");
                } else {
                    System.out.print("Digite a data da chamada (dd/mm/aaaa): ");
                    String data = scanner.next();

                    List<AlunoPresenca> presencas = new ArrayList<>();

                    for (String nome : listaDeAlunos.getListaAlunos()) {
                        System.out.print(nome + " está presente? s/n: ");
                        String presencaAbreviado = scanner.next();
                        String presenca = "AUSENTE ";
                        if (presencaAbreviado.equals("s")) {
                            presenca = "Presente";
                        }
                        AlunoPresenca alunoPresenca = new AlunoPresenca(nome, presenca);
                        presencas.add(alunoPresenca);
                    }
                    presencasDB.addNovaChamada(data, presencas);
                    System.out.println("Chamada do dia " + data + " registrada com sucesso.");
                }
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
            case 4 : { // Exibir diário de classe em tabela
                System.out.println("---------------- DIÁRIO DE CLASSE ---------------- ");
                System.out.print("| Nomes/Datas | ");

                String[] datasOrdenadas = new String[presencasDB.getDiarioClasse().size()];
                int i = 0;
                for (String data : presencasDB.getDiarioClasse().keySet()) { // Gerar vetor com datas
                    datasOrdenadas[i] = data;
                    i++;
                }
                Arrays.sort(datasOrdenadas);
                for (String data : datasOrdenadas) {
                    System.out.print(data + " | "); // Imprimindo datas ordenadas
                }
                System.out.println("");
                for (String nomeLinha : listaDeAlunos.getListaAlunos()) {
                    System.out.print("|    " + nomeLinha + "     |  ");
                    for (String data : datasOrdenadas) {
                        List<AlunoPresenca> presencas = presencasDB.getDiarioClasse().get(data);
                        String presencaCelula = null;
                        for (AlunoPresenca aluno : presencas) {
                            String nome = aluno.getNome();
                            if (nome == nomeLinha) {
                                presencaCelula = aluno.getPresente();
                                System.out.print(presencaCelula + "  |  ");
                            }
                        }
                        if (presencaCelula == null) {
                            System.out.print("Não Reg.  |  ");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("--------------------------------------------------");
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
                listaDeAlunos.addNovoAluno("Mara");

                List<AlunoPresenca> presencas = new ArrayList<>();
                AlunoPresenca alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(0),"Presente");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(1),"Presente");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(2),"Presente");
                presencas.add(alunoPresenca);
                presencasDB.addNovaChamada("12/02/2022",presencas);

                presencas = new ArrayList<>();
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(0),"AUSENTE ");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(1),"AUSENTE ");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(2),"AUSENTE ");
                presencas.add(alunoPresenca);
                presencasDB.addNovaChamada("13/02/2022",presencas);

                presencas = new ArrayList<>();
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(0),"Presente");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(1),"Presente");
                presencas.add(alunoPresenca);
                alunoPresenca = new AlunoPresenca(listaDeAlunos.getListaAlunos().get(2),"AUSENTE ");
                presencas.add(alunoPresenca);
                presencasDB.addNovaChamada("14/02/2022",presencas);

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

