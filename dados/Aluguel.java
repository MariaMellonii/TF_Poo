package dados;

import java.util.Date;

public class Aluguel {
	private int identificador;
	private Date dataInicial;
	private int periodo;
	private Jogo jogo;
	private Cliente cliente;

	public Aluguel(int identificador, Date dataInicial, int periodo, Jogo jogo, Cliente cliente) {
		this.identificador = identificador;
		this.dataInicial = dataInicial;
		this.periodo = periodo;
		this.jogo = jogo;
		this.cliente = cliente;
	}

	public double calculaValorFinal() {
		double valorAluguelPeriodo = jogo.getValorBase() * periodo;
		double valorFinal = 0.0;

		if (cliente instanceof Individual) {
			if (periodo < 7) {
				valorFinal = 0.9 * valorAluguelPeriodo;
			} else if (periodo <= 14) {
				valorFinal = 0.8 * valorAluguelPeriodo;
			} else {
				valorFinal = 0.75 * valorAluguelPeriodo;
			}
		} else if (cliente instanceof Empresarial) {
			if (jogo instanceof JogoEletronico){
				valorFinal = valorAluguelPeriodo;
			} else if (jogo instanceof JogoMesa) {
				valorFinal = 0.85 * valorAluguelPeriodo;
			}
		}
		return valorFinal;
	}
}
