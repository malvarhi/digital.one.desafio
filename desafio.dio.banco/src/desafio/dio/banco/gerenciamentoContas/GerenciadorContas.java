package desafio.dio.banco.gerenciamentoContas;

import desafio.dio.banco.conta.Conta;

public class GerenciadorContas extends ValidarContas{
	
	public void addCadastro(Conta conta) {
		super.addCadastro(conta);
	}
	
	public void depositar(int numConta, double valorDeposito) {
		Conta conta = verificarConta(numConta);
		if(conta==null) {
			System.out.println("O numero da conta não existe");
		}else if(conta.getNumConta()==numConta) {
			if(validarDepositoSaque(valorDeposito, "O DEPOSITO", conta)) {
				conta.depositar(valorDeposito);
				System.out.println("=======================");
				System.out.println("Cliente :"+conta.getCliente().getNome());
				System.out.println("Valor depositado: "+valorDeposito);
				System.out.println("Saldo Atual :"+conta.getSaldo());
				System.out.println("=======================");
			}
		}	
	}
	
	public void sacar(int numConta, double valorSaque) {
		Conta conta = verificarConta(numConta);
		if(conta==null) {
			System.out.println("O numero da conta não existe");
		}else if(conta.getNumConta()==numConta) {
			if(validarDepositoSaque(valorSaque, "O SAQUE", conta)) {
				if(conta.sacar(valorSaque)) {
					System.out.println("=======================");
					System.out.println("Cliente :"+conta.getCliente().getNome());
					System.out.println("Valor do saque: "+valorSaque);
					System.out.println("Saldo Atual :"+conta.getSaldo());
					System.out.println("=======================");
				}
			}
		}
	}
	
	public void transferir(int contaOrigem, int contaDestino, double valorTransf) {
		Conta contaOrigin = verificarConta(contaOrigem);
		Conta contaDestin = verificarConta(contaDestino);
		if(contaOrigin==null) {
			System.out.println("O numero da conta de origem não existe");
		}else if(contaDestin==null) {
			System.out.println("O numero da conta de destino não existe");
		}else if(contaOrigin.getNumConta()==contaOrigem && contaDestin.getNumConta()==contaDestino) {
			if(validarDepositoSaque(valorTransf, "A TRANSFERENCIA",contaDestin)) {
				if(contaOrigin.sacar(valorTransf)) {
					contaDestin.depositar(valorTransf);
					System.out.println("=======================");
					System.out.println("Transferencia realizada para :"+contaDestin.getCliente().getNome());
					System.out.println("Valor da transferencia: "+valorTransf);
					System.out.println("Saldo Atual :"+contaOrigin.getSaldo());
					System.out.println("=======================");
				}
			}
		}
	}
	
	
	public void saldo(int numConta) {
		Conta conta = verificarConta(numConta);
		if(conta==null) {
			System.out.println("O numero desta conta não existe");
		}else if(conta.getNumConta()==numConta){
			System.out.println("=======================");
			System.out.println(conta.getCliente().getNome()+" seu saldo atual é de :"+conta.getSaldo());
			System.out.println("=======================");
		}
	}
}
