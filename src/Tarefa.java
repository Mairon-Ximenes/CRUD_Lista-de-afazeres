public class Tarefa {
    private String nome;
    private boolean concluida;

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tarefa(String nome, boolean concluida) {
        this.nome = nome;
        this.concluida = concluida;
    }
}
