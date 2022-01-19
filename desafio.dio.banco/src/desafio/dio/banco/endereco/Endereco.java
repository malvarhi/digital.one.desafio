package desafio.dio.banco.endereco;

public class Endereco {
	
	private String nomeEndereco;
	private String endereço;
	private String cep;
	private String bairro;
	private static int CODIGOENDERECO = 1;
	private int codEndereco;
	
	
	public Endereco(String nomeEndereco,String endereco, String cep, String bairro) {
		this.nomeEndereco=nomeEndereco;
		this.endereço=endereco;
		this.cep=cep;
		this.bairro=bairro;
		codEndereco();
	}
	
	public String toString() {
		String dadosEndereco = ("\nNome do Endereço: "+getNomeEndereco()+
		"\nEndereço: "+getEndereço()+
		"\nCEP: "+getCep()+
		"\nBairro: "+getBairro());
		return dadosEndereco;
	}

	private void codEndereco() {
		this.codEndereco=CODIGOENDERECO++;
	}

	private String getNomeEndereco() {
		return nomeEndereco;
	}

	private String getEndereço() {
		return endereço;
	}

	private String getCep() {
		return cep;
	}

	private String getBairro() {
		return bairro;
	}
	
	public int getcodEndereco() {
		return codEndereco;
	}
	
	
}
