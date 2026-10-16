package br.com.fiap.motiva.model;

import br.com.fiap.motiva.enums.NivelAlerta;

/**
 * Equipamento instalado em uma estacao do metro
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public abstract class Equipamento {

    private int id;
    private String fabricante;
    private Estacao estacao;

    /**
     * Cria um equipamento em uma estacao
     *
     * @param id
     * @param fabricante
     * @param estacao
     */
    public Equipamento(int id, String fabricante, Estacao estacao) {
        this.id = id;
        this.fabricante = fabricante;
        this.estacao = estacao;
    }

    /**
     * Calcula o nivel de alerta atual do equipamento
     *
     * @return nivel de alerta atual
     */
    public abstract NivelAlerta calcularAlerta();

    /**
     * Imprime os dados do equipamento no console
     */
    public void imprimirDados() {
        System.out.println("Equipamento " + id + " (" + fabricante + ") - Estacao " + estacao.getNome());
    }

    public int getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Estacao getEstacao() {
        return estacao;
    }
}
