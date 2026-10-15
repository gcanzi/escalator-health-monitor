package br.com.fiap.motiva.enums;

/**
 * Nível de alerta resultante da avaliação de uma leitura de sensor.
 * <p>
 * Cada nível possui um <strong>peso</strong> usado no cálculo do índice de
 * criticidade da escada rolante. Um único sensor crítico deve pesar mais do
 * que vários sensores em atenção, pois indica risco de parada.
 * </p>
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public enum NivelAlerta {

    // Leitura dentro da faixa de operação esperada
    NORMAL(0, "Normal"),

    // Leitura fora do ideal, exige acompanhamento e manutenção programada
    ATENCAO(3, "Atenção"),

    // Leitura em faixa de risco, exige intervenção imediata
    CRITICO(10, "Crítico");

    private final int peso;
    private final String descricao;

    /**
     * Cria um nível de alerta
     *
     * @param peso
     * @param descricao
     */
    NivelAlerta(int peso, String descricao) {
        this.peso = peso;
        this.descricao = descricao;
    }

    public int getPeso() {
        return peso;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Indica se este nível é mais grave do que outro
     *
     * @param outro nível a comparar
     * @return {@code true} se este nível tiver peso maior que {@code outro}
     */
    public boolean isMaisGraveQue(NivelAlerta outro) {
        return this.peso > outro.peso;
    }
}
