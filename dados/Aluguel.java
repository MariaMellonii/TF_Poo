package dados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluguel {
    private int identificador;
    private Date dataInicial;
    private int periodo;
    private Jogo jogo;
    private Cliente cliente;

    public Aluguel(int identificador, String data, int periodo, Jogo jogo, Cliente cliente) {
        this.identificador = identificador;

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.dataInicial = formato.parse(data);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido");
        }
        this.periodo = periodo;
        this.jogo = jogo;
        this.cliente = cliente;
    }

    public double calculaValorFinal() {
        double valorAluguelPeriodo = jogo.calculaAluguel() * periodo;
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
            if (jogo instanceof JogoEletronico) {
                valorFinal = valorAluguelPeriodo;
            } else if (jogo instanceof JogoMesa) {
                valorFinal = 0.85 * valorAluguelPeriodo;
            }
        }
        return valorFinal;
    }


}
