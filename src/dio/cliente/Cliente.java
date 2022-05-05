package dio.cliente;

public class Cliente {
    private static int SEQUENCIAL = 1;
    private int id;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
        this.id = SEQUENCIAL++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            throw new RuntimeException("Nome nao pode ser vazio !");
        }
        this.nome = nome;
    }
}
