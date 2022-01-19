package desafio.dio.banco.conta;

import desafio.dio.banco.cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void tipoConta() {
		super.tipoConta=tipoContaOP.CONTA_POUPAN�A;	
	}

	public String toString() {
		String dadosConta = ("\n===Dados Conta Poupan�a==="+super.imprimirDados()+"\n");
		return dadosConta;
	}

}
