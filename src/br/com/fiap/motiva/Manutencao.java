package br.com.fiap.motiva;

/**
 * Manutencao realizada em uma escada rolante
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Manutencao {

    private String data;
    private String descricao;
    private String tecnico;

    /**
     * Cria o registro de uma manutencao
     *
     * @param data
     * @param descricao
     * @param tecnico
     */
    public Manutencao(String data, String descricao, String tecnico) {
        this.data = data;
        this.descricao = descricao;
        this.tecnico = tecnico;
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

    /**
     * Mostra os dados da manutencao em uma linha.
     *
     * @return texto com os dados da manutencao
     */
    @Override
    public String toString() {
        return "Manutencao " + data + ": " + descricao + " (" + tecnico + ")";
    }
}
