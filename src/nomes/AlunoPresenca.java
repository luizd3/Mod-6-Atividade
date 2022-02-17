package nomes;

import java.util.HashMap;
import java.util.Map;

public class AlunoPresenca {

    private Map<String, String> alunosPresencas = new HashMap<>();


    public Map<String, String> getAlunosPresencas() {
        return alunosPresencas;
    }

    public void addNovoAlunoPresenca (String nome, String presenca) {
        alunosPresencas.put(nome,presenca);
    }
}
