package app;

import dados.*;

public class ACMEJogos {
	public void inicializar() {

	}

	public void executar() {

		Cliente emp = new Empresarial(1, "Maria", "Brasil", "Empresa", "0000.0000.11");
		Jogo jogoEletronico = new JogoEletronico(3, "Minecraft", 100, TipoEletronico.AVENTURA, "PC");

		Aluguel aluguel = new Aluguel(5,"06/04/2025", 10, jogoEletronico, emp);

		System.out.println(aluguel.calculaValorFinal());
	}

}
