package db;

import nomes.AlunoPresenca;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PresencasDB {
    // HashMap contendo a data como chave e uma lista de presenças como valor:
    private Map<String, List<AlunoPresenca>> diarioClasse = new HashMap<>();

    public Map<String, List<AlunoPresenca>> getDiarioClasse() {
        return diarioClasse;
    }

    public void addNovaChamada (String data, List<AlunoPresenca> alunoPresenca) {
        this.diarioClasse.put(data, alunoPresenca);
    }

}
