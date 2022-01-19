package desafio.dio.banco.conta;

import desafio.dio.banco.cliente.Cliente;

public abstract class Conta{
	
	protected enum tipoContaOP {CONTA_POUPANÇA, CONTA_CORRENTE}
	protected tipoContaOP tipoConta;
	private static final int NUM_AGENCIA = 4770;
	private static int INCREMENTO_CONTA = 1;
	private int numConta;
	private int agencia;
	private double saldo = 0.0 ;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		numAgencia();
		numConta();
		tipoConta();
		vincularCliente(cliente);
	}
	
	protected abstract void tipoConta();
	
	public void depositar(double deposito) {
		setSaldo(getSaldo()+deposito);
	}
	
	public void extrato() {
		System.out.println("Saldo Atual: "+getSaldo());
	}
	
	public void sacar(double valor) {
		if(getSaldo()<valor) {
			System.out.println("Valor para saque invalido");
		}else if(getSaldo()>valor) {
			setSaldo(getSaldo()-valor);
			extrato();
		}
	}
	
	private void vincularCliente(Cliente cliente) {
		if(cliente.equals(null)) {
			throw new NullPointerException("Cliente invalido");
		}else {
			setCliente(cliente);
		}
		
	}
	
	private void numAgencia() {
		this.agencia=NUM_AGENCIA;
	}
	
	protected String imprimirDados() {
		String dadosConta = ("===Dados Conta===\n\n"+
				"\nAgencia: "+getAgencia()+
				"\nNumero da Conta: "+getNumConta()+
				"\nSaldo: "+getSaldo()+
				"\n"+cliente.toString());
		return dadosConta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente=cliente;	
	}

	public int getAgencia() {
		return agencia;
	}
	
	public double getSaldo() {
		return saldo;
	}
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public int getNumConta() {
		return numConta;
	}
	
	private void numConta() {
		this.numConta=INCREMENTO_CONTA++;
	}
	
}
