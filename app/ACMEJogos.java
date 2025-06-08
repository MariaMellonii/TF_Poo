package app;

import dados.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ACMEJogos {
	private List<Jogo> listaDeJogos = new ArrayList<>();

	public void inicializar() {

	}

	public void executar() {
		Cliente emp = new Empresarial(1, "Maria", "Brasil", "Empresa", "0000.0000.11");
		Jogo jogoEletronico = new JogoEletronico(3, "Minecraft", 100, TipoEletronico.AVENTURA, "PC");

		Aluguel aluguel = new Aluguel(5,"06/04/2025", 10, jogoEletronico, emp);

		System.out.println(aluguel.calculaValorFinal());

		cadastrarJogos();
	}

	private void cadastrarJogos() {
		try(BufferedReader br = new BufferedReader(new FileReader("CLIENTESENTRADA.csv"))){
			String linha;
			br.readLine();
			while ((linha = br.readLine()) != null){
				String[] dados = linha.split(",");
				int codigo = Integer.parseInt(dados[0]);
				String nome = dados[1];
				double valorBase = Double.parseDouble(dados[2]);
				TipoEletronico tipo = TipoEletronico.valueOf(dados[3]);
				String plataforma = dados[4];

				if(existeCodigo(codigo)){
					System.out.println("Erro código duplicado.");
				} else {
					Jogo novoJogo = new JogoEletronico(codigo, nome, valorBase, tipo, plataforma);
					listaDeJogos.add(novoJogo);
				}
			}
		} catch (NumberFormatException | IOException e){
			System.out.println("Erro linha com dados numéricos inválidos ignorada");
		}

	}

	private boolean existeCodigo(int codigo) {
		for (Jogo jogo : listaDeJogos){
			if (jogo.getCodigo() == codigo){
				return true;
			}
		}
		return false;
	}
}
