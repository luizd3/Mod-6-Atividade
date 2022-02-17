package db;

import nomes.AlunoPresenca;
import java.util.Map;
import java.util.HashMap;

public class PresencasDB {

    // HashMap contendo a data como chave e objeto de 'AlunoPresenca' como valor:
    private Map<String, AlunoPresenca> diarioClasse = new HashMap<>();


    public Map<String, AlunoPresenca> getDiarioClasse() {
        return diarioClasse;
    }


    public void addNovaChamada (String data, AlunoPresenca alunoPresenca) {
        this.diarioClasse.put(data, alunoPresenca);
    }

}
