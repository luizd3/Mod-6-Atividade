import db.PresencasDB;
import nomes.AlunoData;

import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static PresencasDB presencasDB = new PresencasDB();

    public static void main(String[] args) throws Exception {

        int opcao = 0;
        do {
            System.out.println("1 - Registrar nova presença");
            System.out.println("2 - Exibir presenças em lista");
            System.out.println("3 - Exibir diário de classe");
            System.out.println("4 - Preencher dados automaticamente");
            System.out.println("0 - Sair");
            System.out.print("O que deseja fazer: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            menu(opcao);

        } while (opcao != 0);
    }

    public static void menu(int opcao) throws Exception {

        switch (opcao) {
            case 1 : { // Cadastrar nova presença
                Scanner scanner = new Scanner(System.in);

                String nomeAluno;
                String dataPresenca;
                String presenca;

                System.out.print("Nome do Aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("Data do Apontamento (dd/mm/aaaa): ");
                dataPresenca = scanner.nextLine();
                System.out.print("Presente / Ausente: ");
                presenca = scanner.next();
                AlunoData alunoData = new AlunoData(nomeAluno,dataPresenca);
                presencasDB.setDiarioClasse(alunoData,presenca);
                System.out.println("Presença registrada");
                break;
            }
            case 2 : { // Exibir presença em forma de lista
                Map<AlunoData, String> diarioClasse = presencasDB.getDiarioClasse();

                System.out.println("----- PRESENÇAS REGISTRADAS EM LISTA -----");
                for (AlunoData a : diarioClasse.keySet()){
                    System.out.println("Nome: " + a.getNomeAluno());
                    System.out.println("Data: " + a.getDataPresenca());
                    System.out.println("Presenca: " + diarioClasse.get(a));
                    System.out.println("-----------------------------");
                }
                break;
            }
            case 3 : { // Exibir tabela Diário de Classe
                Map<AlunoData, String> diarioClasse = presencasDB.getDiarioClasse();

                Set<String> hashSetDatas = new HashSet<>(); // Criado Set para obter valores únicos de data.

                for (AlunoData a : diarioClasse.keySet()) {
                    String data = a.getDataPresenca();
                    hashSetDatas.add(data);
                }

                List<String> listaDatas = new ArrayList<>(); // Criada Lista para poder ordenar a lista única de datas.

                for (String a : hashSetDatas){
                    listaDatas.add(a);
                }

                Collections.sort(listaDatas); // Ordenação das datas
                System.out.println(listaDatas);

                // Obter uma lista de nomes únicos de forma ordenada. Usar HashSet e ArrayList

                Set<String> hashSetNomes = new HashSet<>();

                for (AlunoData a : diarioClasse.keySet()) {
                    String nome = a.getNomeAluno();
                    hashSetNomes.add(nome);
                }

                // Lista para ordenar os nomes.
                List<String> listaNomes = new ArrayList<>(hashSetNomes);

                Collections.sort(listaNomes);

                for (String a : listaNomes) {
                    System.out.println(a);
                }

                // Construir um objeto Nome/Data utilizando as listas indexadas.
                String nome = listaNomes.get(1);
                String data = listaDatas.get(1);
                AlunoData nomeData = new AlunoData(nome,data);

                // Procurar no mapa 'diarioClasse' pelas chaves 'nome/data', obtendo o valor 'presenca'.

                String presenca = diarioClasse.get(nomeData); // Erro: Retorna sempre 'null'.
                System.out.println(nome + " - " + data + " - " + presenca);

                break;
            }
            case 4 : { // Adicionando novos valores para testar o código.
                AlunoData alunoData = new AlunoData("Santos Dumont", "15/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Presente");
                alunoData = new AlunoData("Santos Dumont", "16/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Ausente");
                alunoData = new AlunoData("Machado de Assis", "15/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Ausente");
                alunoData = new AlunoData("Machado de Assis", "16/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Presente");
                alunoData = new AlunoData("Silvio Santos", "15/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Ausente");
                alunoData = new AlunoData("Silvio Santos", "17/02/2022");
                presencasDB.setDiarioClasse(alunoData, "Ausente");
                }
                break;
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

