package desafio.dio.banco;

import java.lang.instrument.IllegalClassFormatException;

import desafio.dio.banco.cliente.Cliente;
import desafio.dio.banco.conta.Conta;
import desafio.dio.banco.conta.ContaPoupanca;
import desafio.dio.banco.endereco.Endereco;
import desafio.dio.banco.gerenciamentoContas.GerenciadorContas;

public class Banco {
		
	public static void main(String[] args) throws IllegalClassFormatException{
		GerenciadorContas gerenciador = new GerenciadorContas();
		
		Endereco endereco = new Endereco("Casa", "Caminho das flores", "1324-5678", "Nobre");
		Cliente cliente = new Cliente("marcos", "05120413501", endereco);
		Conta conta = new ContaPoupanca(cliente);
		
		Endereco endereco1 = new Endereco("Predio", "avenida paulista", "741-25874", "Centro");
		Cliente cliente1 = new Cliente("Vinicius", "123456789", endereco1);
		Conta conta1 = new ContaPoupanca(cliente1);
		
		gerenciador.addCadastro(conta);
		gerenciador.addCadastro(conta1);
		
		gerenciador.depositar(1, 50);
		gerenciador.sacar(1, 15);
		gerenciador.transferir(1, 2, 40);
		gerenciador.saldo(2);
	}

}
