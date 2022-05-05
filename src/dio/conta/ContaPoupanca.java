package dio.conta;

import dio.cliente.Cliente;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente, "CONTA POUPANCA");
    }
}
