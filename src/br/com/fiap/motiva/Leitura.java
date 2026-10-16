package br.com.fiap.motiva;

/**
 * Leitura dos sensores de uma escada rolante
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Leitura {

    private String dataHora;
    private double vibracao;
    private double temperatura;
    private double corrente;
    private double tensao;
    private double nivelOleo;
    private double velocidade;

    /**
     * Cria uma leitura com os valores dos sensores
     *
     * @param dataHora
     * @param vibracao
     * @param temperatura
     * @param corrente
     * @param tensao
     * @param nivelOleo
     * @param velocidade
     *
     * @throws IllegalArgumentException se o nivel de oleo estiver fora de 0 a 100
     */
    public Leitura(String dataHora, double vibracao, double temperatura, double corrente,
                   double tensao, double nivelOleo, double velocidade) {
        this.dataHora = dataHora;
        this.vibracao = vibracao;
        this.temperatura = temperatura;
        this.corrente = corrente;
        this.tensao = tensao;
        setNivelOleo(nivelOleo);
        this.velocidade = velocidade;
    }

    /**
     * Calcula o nivel de alerta da leitura comparando os valores com os limites
     *
     * @return nivel de alerta da leitura
     */
    public NivelAlerta getNivelAlerta() {
        if (temperatura > 90 || vibracao > 7.1 || nivelOleo < 20) {
            return NivelAlerta.CRITICO;
        }
        if (temperatura > 70 || vibracao > 4.5 || nivelOleo < 40) {
            return NivelAlerta.ATENCAO;
        }
        return NivelAlerta.NORMAL;
    }

    public String getDataHora() {
        return dataHora;
    }

    public double getVibracao() {
        return vibracao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getCorrente() {
        return corrente;
    }

    public double getTensao() {
        return tensao;
    }

    public double getNivelOleo() {
        return nivelOleo;
    }

    /**
     * Altera o nivel de oleo, que precisa estar entre 0 e 100
     *
     * @param nivelOleo
     *
     * @throws IllegalArgumentException se o nivel de oleo estiver fora de 0 a 100
     */
    public void setNivelOleo(double nivelOleo) {
        if (nivelOleo < 0 || nivelOleo > 100) {
            throw new IllegalArgumentException("Nivel de oleo invalido: " + nivelOleo + "%");
        }
        this.nivelOleo = nivelOleo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    /**
     * Mostra os valores da leitura em uma linha
     *
     * @return texto com os dados da leitura
     */
    @Override
    public String toString() {
        return dataHora + " | vib=" + vibracao + " temp=" + temperatura + " corr=" + corrente
                + " tens=" + tensao + " oleo=" + nivelOleo + "% vel=" + velocidade + " -> " + getNivelAlerta();
    }
}
