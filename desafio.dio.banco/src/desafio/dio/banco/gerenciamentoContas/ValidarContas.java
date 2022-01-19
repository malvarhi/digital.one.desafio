package desafio.dio.banco.gerenciamentoContas;

import java.util.ArrayList;
import java.util.List;

import desafio.dio.banco.conta.Conta;

public class ValidarContas {
	private List<Conta> contas;
	
	public ValidarContas() {
		contas = new ArrayList<Conta>();
	}
	
	protected Conta verificarConta(int numConta) {
		for (Conta conta : contas) {
			if(conta.getNumConta()==numConta) {
				return conta;
			}
		}
		return null;
	}
}
