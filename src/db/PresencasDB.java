package db;

import nomes.AlunoData;
import java.util.Map;
import java.util.HashMap;

// Conterá Coleção do tipo HashMap ligando o par chave 'aluno/data' ao valor 'presença'

public class PresencasDB {

    private Map<AlunoData, String> diarioClasse = new HashMap<>();


    public Map<AlunoData, String> getDiarioClasse() {
        return diarioClasse;
    }

    public void setDiarioClasse (AlunoData alunoData, String presenca) {
        this.diarioClasse.put(alunoData, presenca);
    }

}
