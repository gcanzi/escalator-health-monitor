package br.com.fiap.motiva.enums;

/**
 * Situação operacional de um equipamento.
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public enum StatusEquipamento {

    // Equipamento em funcionamento normal, atendendo passageiros
    OPERANTE("Operante"),

    // Equipamento parado para manutenção programada ou corretiva
    EM_MANUTENCAO("Em manutenção"),

    // Equipamento parado por falha, aguardando atendimento
    FORA_DE_OPERACAO("Fora de operação");

    private final String descricao;

    /**
     * Cria um status de equipamento
     *
     * @param descricao
     */
    StatusEquipamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
