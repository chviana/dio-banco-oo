package dio.banco;

import dio.conta.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionaConta(Conta conta) {
        getContas().add(conta);
    }

    private List<Conta> getContas() {
        if(contas == null) {
            contas = new ArrayList<>();
        }
        return contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
