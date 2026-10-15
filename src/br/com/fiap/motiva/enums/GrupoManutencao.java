package br.com.fiap.motiva.enums;

/**
 * Equipe de manutenção responsável por atender um tipo de falha.
 * <p>
 * Cada sensor declara o grupo que trata as anomalias da grandeza que mede,
 * e o serviço de criticidade usa essa informação para sugerir qual equipe
 * deve ser enviada a cada escada.
 * </p>
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public enum GrupoManutencao {

    // Responsabilidades: degraus, correntes, rolamentos, alinhamento e velocidade
    MECANICO("Mecânica"),

    // Responsabilidades: motor, alimentação, inversor e proteções
    ELETRICO("Elétrica"),

    // Responsabilidades: óleo do redutor e pontos de graxa
    LUBRIFICACAO("Lubrificação");

    private final String descricao;

    /**
     * Cria um grupo de manutenção
     *
     * @param descricao
     */
    GrupoManutencao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
