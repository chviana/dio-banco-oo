package dio.conta;

import dio.cliente.Cliente;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente, "CONTA CORRENTE");
    }
}
