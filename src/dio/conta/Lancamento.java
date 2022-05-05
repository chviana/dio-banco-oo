package dio.conta;

import java.time.LocalDateTime;

public class Lancamento {

    private static int SEQUENCIAL = 1;
    private long id;
    private double valor;
    private TipoLancamento tipoLancamento;
    private String descricao;
    private LocalDateTime dataHora;

    public Lancamento(double valor, String descricao, TipoLancamento tipoLancamento) {
        this.id = SEQUENCIAL++;
        this.valor = valor;
        this.descricao = descricao;
        this.tipoLancamento = tipoLancamento;
        this.dataHora = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
