package dio;

import dio.banco.Banco;
import dio.cliente.Cliente;
import dio.conta.Conta;
import dio.conta.ContaCorrente;
import dio.conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco digital");

        Cliente joao = new Cliente("Joao da Silva");
        Cliente maria = new Cliente("Maria da Silva");
        Cliente carlos = new Cliente("Carlos Barbosa");
        Cliente clarissa = new Cliente("Clarissa dos Santos");

        Conta contaCorrenteJoao = new ContaCorrente(joao);
        Conta contaPoupancaJoao = new ContaPoupanca(joao);

        Conta contaCorrenteMaria = new ContaCorrente(maria);
        Conta contaPoupancaMaria = new ContaPoupanca(maria);

        Conta contaCorrenteCarlos = new ContaCorrente(carlos);
        Conta contaPoupancaCarlos = new ContaPoupanca(carlos);

        Conta contaCorrenteClarissa = new ContaCorrente(clarissa);
        Conta contaPoupancaClarissa = new ContaPoupanca(clarissa);

        banco.adicionaConta(contaCorrenteJoao);
        banco.adicionaConta(contaPoupancaJoao);

        banco.adicionaConta(contaCorrenteMaria);
        banco.adicionaConta(contaPoupancaMaria);

        banco.adicionaConta(contaCorrenteCarlos);
        banco.adicionaConta(contaPoupancaCarlos);

        banco.adicionaConta(contaCorrenteClarissa);
        banco.adicionaConta(contaPoupancaClarissa);

        // Depósitos
        contaCorrenteJoao.depositar(500);
        contaCorrenteJoao.depositar(300);
        contaCorrenteCarlos.depositar(1300);
        contaCorrenteMaria.depositar(5000);

        // Saques
        contaCorrenteJoao.sacar(200);
        contaCorrenteJoao.sacar(250);
        contaCorrenteCarlos.sacar(150);

        // Transferencias
        contaCorrenteJoao.transferir(100, contaCorrenteCarlos);
        contaCorrenteMaria.transferir(700, contaPoupancaCarlos);

        // Extratos
        contaCorrenteJoao.imprimirExtrato();
        contaCorrenteCarlos.imprimirExtrato();
        contaPoupancaCarlos.imprimirExtrato();
        contaCorrenteMaria.imprimirExtrato();

    }

}
