package dados;
import static dados.TipoEletronico.AVENTURA;

public class JogoEletronico extends Jogo {
	private TipoEletronico tipo;
	private String plataforma;

	public JogoEletronico(int codigo, String nome, double valorBase, TipoEletronico tipo, String plataforma) {
		super(codigo, nome, valorBase);
		this.tipo = tipo;
		this.plataforma = plataforma;
	}

	public TipoEletronico getTipo() {
		return tipo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public double calculaAluguel() {
		if (tipo == tipo.AVENTURA) {
			return getValorBase() * 1.05;
		} else if (tipo == tipo.ESTRATEGIA) {
			return getValorBase() * 1.15;
		} else if (tipo == tipo.SIMULACAO) {
			return getValorBase() * 1.25;
		} else {
			return getValorBase();
		}
	}
}
