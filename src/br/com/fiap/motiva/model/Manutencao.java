package br.com.fiap.motiva.model;

import br.com.fiap.motiva.enums.TipoManutencao;

/**
 * Manutencao de uma escada rolante, preventiva ou aberta por causa de um alerta
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Manutencao {

    private String data;
    private String descricao;
    private String tecnico;
    private TipoManutencao tipo;

    /**
     * Cria o registro de uma manutencao
     *
     * @param data
     * @param descricao
     * @param tecnico
     * @param tipo
     */
    public Manutencao(String data, String descricao, String tecnico, TipoManutencao tipo) {
        this.data = data;
        this.descricao = descricao;
        this.tecnico = tecnico;
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public TipoManutencao getTipo() {
        return tipo;
    }

    public void setTipo(TipoManutencao tipo) {
        this.tipo = tipo;
    }

    /**
     * Mostra os dados da manutencao em uma linha
     *
     * @return texto com os dados da manutencao
     */
    @Override
    public String toString() {
        return "Manutencao [" + tipo + "] " + data + ": " + descricao + " (" + tecnico + ")";
    }
}
