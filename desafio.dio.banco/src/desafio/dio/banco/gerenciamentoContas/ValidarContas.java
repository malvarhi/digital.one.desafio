package desafio.dio.banco.gerenciamentoContas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import desafio.dio.banco.conta.Conta;

public class ValidarContas {
	private List<Conta> contas;
	
	
	protected void addCadastro(Conta conta) {
		getContas().add(conta);
	}

	protected Conta verificarConta(int numConta) {
		for (Conta conta : contas) {
			if(conta.getNumConta()==numConta) {
				return conta;
			}
		}
		return null;
	}
	
	protected boolean validarDepositoSaque(double valorDeposito,String modificador,Conta conta) {
		@SuppressWarnings("resource") //metodo scan não pode ser fechado
		Scanner scan = new Scanner(System.in);
		System.out.println("\n================================================================");
		System.out.println("Conta Destino: "+conta.getCliente().getNome()+" "
				+ "\nNumero da Conta: "+conta.getNumConta());
		System.out.println("Você deseja confirmar "+modificador+" de "+valorDeposito+" ?");
		System.out.println("digite S para confirmar ou N para cancelar");
		System.out.println("================================================================\n");
		String check = scan.nextLine();
		if(check.equalsIgnoreCase("S")) {
			return true;
		}else if(check.equalsIgnoreCase("N")) {
			System.out.println("\n===============================");
			System.out.println("Operação Cancelada pelo Usuario");
			System.out.println("===============================\n");
			return false;
		}
		return false;		
	}
	

	private List<Conta> getContas() {
		if(contas==null) {
			contas = new ArrayList<Conta>();
		}
		return contas;
	}
	
	
}
