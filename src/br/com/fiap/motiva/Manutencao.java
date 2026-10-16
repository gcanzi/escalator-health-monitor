package br.com.fiap.motiva;

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
    private String urgencia;

    /**
     * Cria o registro de uma manutencao
     *
     * @param data
     * @param descricao
     * @param tecnico
     * @param urgencia
     */
    public Manutencao(String data, String descricao, String tecnico, String urgencia) {
        this.data = data;
        this.descricao = descricao;
        this.tecnico = tecnico;
        this.urgencia = urgencia;
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

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    /**
     * Mostra os dados da manutencao em uma linha
     *
     * @return texto com os dados da manutencao
     */
    @Override
    public String toString() {
        return "Manutencao [" + urgencia + "] " + data + ": " + descricao + " (" + tecnico + ")";
    }
}
