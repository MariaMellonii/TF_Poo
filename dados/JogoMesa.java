package dados;

public class JogoMesa extends Jogo {
	private TipoMesa tipo;
	private int numeroPecas;

	public JogoMesa(int codigo, String nome, double valorBase, TipoMesa tipo, int numeroPecas) {
		super(codigo, nome, valorBase);
		this.tipo = tipo;
		this.numeroPecas = numeroPecas;
	}

	public TipoMesa getTipo() {
		return tipo;
	}

	public int getNumeroPecas() {
		return numeroPecas;
	}

	public double calculaAluguel() {
		if (tipo == tipo.TABULEIRO) {
			return getValorBase() * numeroPecas;
		} else if (tipo == tipo.CARTAS){
			return getValorBase() * 2.2;
		}else {
			return getValorBase();
		}
	}
}
