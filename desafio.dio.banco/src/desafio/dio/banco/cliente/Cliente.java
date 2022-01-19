package desafio.dio.banco.cliente;

import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.List;

import desafio.dio.banco.endereco.Endereco;

public class Cliente{
	private static int INCREMENTO_COD_CLIENTE = 1;
	private String nome;
	private String cpf;
	private int codigoCliente;
	private List<Endereco> enderecos; 
	
	public Cliente(String nome, String cpf, Endereco endereco) throws IllegalClassFormatException {
		setNome(nome);
		setCpf(cpf);
		codigoCliente();
		addEndereco(endereco);
	}
	
	private void addEndereco(Endereco endereco) {
		if(endereco==null) {
			throw new NullPointerException("Endereco invalido");
		}else {
			getEnderecos().add(endereco);
		}
	}
	
	private List<Endereco> getEnderecos() {
		if(enderecos==null) {
			enderecos = new ArrayList<Endereco>();
		}
		return enderecos;
	}

	private void setNome(String nome) {
		if(nome.isEmpty() || nome.isBlank()) {
			throw new IllegalArgumentException("Nome Invalido");
		}else {
			this.nome=nome;
		}
	}
	
	private void setCpf(String cpf) {
		if(cpf.isEmpty() || cpf.isBlank()) {
			throw new IllegalArgumentException("CPF Invalido");
		}else {
			this.cpf=cpf;
		}
	}
	
	private void codigoCliente() {
		this.codigoCliente=INCREMENTO_COD_CLIENTE++;
	}
	
	public String toString() {
		String dadosCliente = ("Nome Cliente: "+getNome()+
				"\n\n===Endereço==="+getEnderecos().toString());
		return dadosCliente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}

	
		
}
