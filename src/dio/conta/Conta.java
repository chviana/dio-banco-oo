package dio.conta;

import dio.cliente.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private String tipoConta;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Lancamento> lancamentos;

    public Conta(Cliente cliente, String tipoConta) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    public void imprimirExtrato() {

        String tipoConta = this.tipoConta;
        int idCliente = this.cliente.getId();
        String nomeCliente = this.cliente.getNome();
        double saldo = this.saldo;

        System.out.println(String.format("EXTRATO %s", tipoConta));
        System.out.println("---------------------------------------------------------------");
        System.out.println(String.format("Cliente: %d - %s", idCliente, nomeCliente));
        System.out.println(String.format("Saldo: R$ %.2f", saldo));
        System.out.println("---------------------------------------------------------------");

        lancamentos.forEach(lancamento -> {
            String sinalCreditoDebito = lancamento.getTipoLancamento() == TipoLancamento.DEBITO ? "-" : "+";
            String descricao = lancamento.getDescricao();
            String dataHora = lancamento.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            double valor = lancamento.getValor();
            System.out.println(String.format("%s %-40s %10.2f%s", dataHora, descricao, valor, sinalCreditoDebito));
        });
        System.out.println("---------------------------------------------------------------");
        System.out.println();
    }

    private void adicionaLancamento(double valor, String descricao, TipoLancamento tipoLancamento) {
        Lancamento lancamento = new Lancamento(valor, descricao, tipoLancamento);
        getLancamentos().add(lancamento);
    }
    private List<Lancamento> getLancamentos() {
        if(lancamentos == null) {
            lancamentos = new ArrayList<>();
        }
        return lancamentos;
    }
    public void sacar(double valor) {
        this.sacar(valor, "Saque");
    }

    public void depositar(double valor) {
        this.depositar(valor, "Deposito");
    }

    private void sacar(double valor, String descricao) {
        if (valor > saldo) {
            throw new RuntimeException("Saldo insuficiente !");
        } else if (valor <= 0) {
            throw new RuntimeException("Valor não pode ser zero ou negativo !");
        }
        saldo -= valor;
        adicionaLancamento(valor, descricao, TipoLancamento.DEBITO);
    }

    private void depositar(double valor, String descricao) {
        if (valor <= 0) {
            throw new RuntimeException("Valor não pode ser zero ou negativo !");
        }
        saldo += valor;
        adicionaLancamento(valor, descricao, TipoLancamento.CREDITO);
    }

    public void transferir(double valor, Conta contaDestino) {
        String str = "Transf. p/ " + contaDestino.cliente.getNome();
        this.sacar(valor, str);
        str = "Transf. de " + this.cliente.getNome();
        contaDestino.depositar(valor, str);
    }
}
