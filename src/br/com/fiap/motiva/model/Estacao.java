package br.com.fiap.motiva.model;

/**
 * Estacao do metro onde ficam as escadas rolantes
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Estacao {

    private int id;
    private String nome;
    private Linha linha;

    /**
     * Cria uma estacao ligada a uma linha
     *
     * @param id
     * @param nome
     * @param linha
     */
    public Estacao(int id, String nome, Linha linha) {
        this.id = id;
        this.nome = nome;
        this.linha = linha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Linha getLinha() {
        return linha;
    }

    /**
     * Mostra os dados da estacao e da linha
     *
     * @return texto com os dados da estacao
     */
    @Override
    public String toString() {
        return "Estacao " + id + " - " + nome + " | " + linha;
    }
}
