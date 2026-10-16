package br.com.fiap.motiva;

/**
 * Linha do metro
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Linha {

    private int id;
    private String nome;
    private String cor;

    /**
     * Cria uma linha do metro
     *
     * @param id
     * @param nome
     * @param cor
     */
    public Linha(int id, String nome, String cor) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Mostra os dados da linha em uma linha de texto
     *
     * @return texto com os dados da linha
     */
    @Override
    public String toString() {
        return "Linha " + id + " - " + nome + " (" + cor + ")";
    }
}
