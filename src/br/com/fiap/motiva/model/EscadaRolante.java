package br.com.fiap.motiva.model;

import br.com.fiap.motiva.enums.NivelAlerta;
import br.com.fiap.motiva.enums.SentidoMovimento;
import br.com.fiap.motiva.enums.TipoManutencao;

import java.util.ArrayList;

/**
 * Escada rolante com suas leituras e manutencoes
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class EscadaRolante extends Equipamento {

    private SentidoMovimento sentido;
    private ArrayList<Leitura> leituras = new ArrayList<>();
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();

    /**
     * Cria uma escada rolante em uma estacao
     *
     * @param id
     * @param fabricante
     * @param estacao
     * @param sentido
     */
    public EscadaRolante(int id, String fabricante, Estacao estacao, SentidoMovimento sentido) {
        super(id, fabricante, estacao);
        this.sentido = sentido;
    }

    /**
     * Registra uma leitura ja criada e abre uma manutencao se ela gerar alerta
     * (URGENTE para nivel critico e PROGRAMADA para nivel de atencao)
     *
     * @param leitura
     */
    public void registrarLeitura(Leitura leitura) {
        leituras.add(leitura);

        NivelAlerta nivel = leitura.getNivelAlerta();
        String descricao = "Verificar " + leitura.descreverProblema();
        if (nivel == NivelAlerta.CRITICO) {
            manutencoes.add(new Manutencao(leitura.getDataHora(), descricao, "A definir", TipoManutencao.URGENTE));
        } else if (nivel == NivelAlerta.ATENCAO) {
            manutencoes.add(new Manutencao(leitura.getDataHora(), descricao, "A definir", TipoManutencao.PROGRAMADA));
        }
    }

    /**
     * Registra uma leitura a partir dos valores dos sensores
     *
     * @param dataHora
     * @param vibracao
     * @param temperatura
     * @param corrente
     * @param tensao
     * @param nivelOleo
     * @param velocidade
     *
     * @throws IllegalArgumentException se o nivel de oleo estiver fora de 0 a 100
     */
    public void registrarLeitura(String dataHora, double vibracao, double temperatura, double corrente,
                                 double tensao, double nivelOleo, double velocidade) {
        registrarLeitura(new Leitura(dataHora, vibracao, temperatura, corrente, tensao, nivelOleo, velocidade));
    }

    /**
     * Adiciona uma manutencao feita na escada
     *
     * @param manutencao
     */
    public void adicionarManutencao(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }

    /**
     * Busca a leitura mais recente da escada
     *
     * @return ultima leitura, ou null se nao houver leituras
     */
    public Leitura getUltimaLeitura() {
        if (leituras.isEmpty()) {
            return null;
        }
        return leituras.get(leituras.size() - 1);
    }

    /**
     * Calcula a media de temperatura das leituras
     *
     * @return media de temperatura, ou 0 se nao houver leituras
     */
    public double calcularMediaTemperatura() {
        if (leituras.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Leitura leitura : leituras) {
            soma += leitura.getTemperatura();
        }
        return soma / leituras.size();
    }

    /**
     * Calcula o nivel de alerta pela ultima leitura da escada
     *
     * @return nivel de alerta atual
     */
    @Override
    public NivelAlerta calcularAlerta() {
        Leitura ultima = getUltimaLeitura();
        if (ultima == null) {
            return NivelAlerta.NORMAL;
        }
        return ultima.getNivelAlerta();
    }

    /**
     * Imprime os dados da escada, as leituras e as manutencoes
     */
    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("  Sentido: " + sentido + " | Alerta: " + calcularAlerta()
                + " | Media de temperatura: " + calcularMediaTemperatura());
        for (Leitura leitura : leituras) {
            System.out.println("  " + leitura);
        }
        for (Manutencao manutencao : manutencoes) {
            System.out.println("  " + manutencao);
        }
    }

    public SentidoMovimento getSentido() {
        return sentido;
    }

    public void setSentido(SentidoMovimento sentido) {
        this.sentido = sentido;
    }

    public ArrayList<Leitura> getLeituras() {
        return leituras;
    }

    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }

    /**
     * Mostra a escada em uma linha de texto
     *
     * @return texto com os dados da escada
     */
    @Override
    public String toString() {
        return "Escada " + getId() + " (" + sentido + ") na estacao " + getEstacao().getNome();
    }
}
