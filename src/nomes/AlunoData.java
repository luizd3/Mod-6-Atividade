package nomes;

public class AlunoData {

    private String nomeAluno;
    private String dataPresenca;

    public AlunoData (String nomeAluno, String dataPresenca) {
        this.nomeAluno = nomeAluno;
        this.dataPresenca = dataPresenca;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getDataPresenca() {
        return dataPresenca;
    }

    public void setNomeAluno() {
        this.nomeAluno = nomeAluno;
    }

    public void setDataPresenca() {
        this.dataPresenca = dataPresenca;
    }
}
