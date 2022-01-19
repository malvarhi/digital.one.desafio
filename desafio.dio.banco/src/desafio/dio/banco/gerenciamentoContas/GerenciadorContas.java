package desafio.dio.banco.gerenciamentoContas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import desafio.dio.banco.conta.Conta;

public class GerenciadorContas extends ValidarContas{
		private List<Conta> contas;
		
	public GerenciadorContas() {
		contas = new ArrayList<Conta>();
		
	}
	
	public void addCadastro(Conta conta) {
		this.contas.add(conta);
	}
	
	public void depositar(int numConta, double valorDeposito) {
			boolean flag=true;
			for (Conta conta : contas) {
				if(conta.getNumConta()==numConta) {
					if(valorDeposito>0) {
						conta.depositar(valorDeposito);
						flag=false;
					}else {
						System.out.println("Valor do deposito invalido");
					}
				}
			}
			
			if(flag)System.out.println("Numero de conta invalida");
		
		
		
	}
	
	public void transferir(int contaOrigin, int contaDestino, double valor) {
		Conta tempContaOrigin = verificarConta(contaOrigin);
		Conta tempContaDestino = verificarConta(contaDestino);
		System.out.println(contaDestino);
		if(tempContaOrigin.getSaldo()>valor) {
			System.out.println("Conta destino: "+tempContaDestino.getNumConta()+
					"\nConta Destino: "+tempContaDestino.getCliente().getNome()+
					"\nValor: "+valor);
			System.out.println("Deseja mesmo realizar a transferencia? Digite S para sim e N para não");
		}
		Scanner scan=new Scanner(System.in);
		String resposta = scan.nextLine();
		scan.close();
		if(confirmarTransferencia(resposta)) {
			tempContaOrigin.sacar(valor);
			tempContaDestino.depositar(valor);
			System.out.println("\nValor depositado: "+valor+"\nConta Destinataria: "+tempContaDestino.getCliente().getNome());
		}else {
			System.out.println("\nOperação cancelada");
		}
	}

	
	private boolean confirmarTransferencia(String resposta){
		if(resposta.equalsIgnoreCase("S")) {
			return true;
		}else if(resposta.equalsIgnoreCase("N")){
			return false;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return getContas().toString();
	}

	private List<Conta> getContas() {
		return contas;
	}
	
}
