package desafio.dio.banco.conta;

import desafio.dio.banco.cliente.Cliente;

public class ContaCorrente extends Conta {


	public ContaCorrente(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void tipoConta() {
		super.tipoConta=tipoContaOP.CONTA_CORRENTE;	
	}

	public String toString() {
		String dadosConta = ("\n===Dados Conta Corrente==="+super.imprimirDados()+"\n");
		return dadosConta;
	}
}
