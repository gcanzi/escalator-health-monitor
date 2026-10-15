package br.com.fiap.motiva.enums;

/**
 * Sentido de movimento configurado para uma escada rolante.
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public enum SentidoMovimento {

    // Escada operando somente no sentido de subida
    SUBIDA("Subida"),

    // Escada operando somente no sentido de descida
    DESCIDA("Descida"),

    // Escada que alterna o sentido conforme o fluxo de passageiros
    REVERSIVEL("Reversível");

    private final String descricao;

    /**
     * Cria um sentido de movimento
     *
     * @param descricao
     */
    SentidoMovimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
