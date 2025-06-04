package dados;

public abstract class Jogo {
	private int codigo;
	private String nome;
	private double valorBase;

	public Jogo(int codigo, String nome, double valorBase) {
		this.codigo = codigo;
		this.nome = nome;
		this.valorBase = valorBase;

	}

	public abstract double calculaAluguel();

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public double getValorBase() {
		return valorBase;
	}

}
