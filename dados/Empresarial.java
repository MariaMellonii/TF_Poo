package dados;

public class Empresarial extends Cliente {
	private String nomeFantasia;
	private String cnpj;

	public Empresarial(int numero, String nome, String endereco, String nomeFantasia, String cnpj) {
		super(numero, nome, endereco);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}
}
