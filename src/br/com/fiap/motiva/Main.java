package br.com.fiap.motiva;

import java.util.ArrayList;

/**
 * Classe principal que cria os objetos do sistema e imprime os dados
 *
 * @author Gustavo Canzi
 * @version 1.0
 * @since 1.0
 */
public class Main {

    /**
     * Cria as linhas, estacoes, escadas, leituras e manutencoes e imprime tudo no console
     *
     * @param args
     */
    public static void main(String[] args) {
        Linha linha4 = new Linha(4, "Amarela", "Amarelo");
        Linha linha5 = new Linha(5, "Lilas", "Lilas");

        Estacao paulista = new Estacao(1, "Paulista", linha4);
        Estacao fariaLima = new Estacao(2, "Faria Lima", linha4);
        Estacao santoAmaro = new Estacao(3, "Santo Amaro", linha5);

        EscadaRolante escada1 = new EscadaRolante(101, "Otis", paulista, "SUBIDA");
        EscadaRolante escada2 = new EscadaRolante(102, "Schindler", paulista, "DESCIDA");
        EscadaRolante escada3 = new EscadaRolante(201, "TK Elevator", fariaLima, "SUBIDA");
        EscadaRolante escada4 = new EscadaRolante(301, "Otis", santoAmaro, "DESCIDA");

        // manutencao preventiva feita antes das leituras
        escada1.adicionarManutencao(new Manutencao("01/10/2026", "Lubrificacao preventiva", "Ana Lima", "PREVENTIVA"));

        // escada 101: saudavel, nao abre manutencao
        Leitura leitura = new Leitura("15/10/2026 08:00", 1.8, 55, 24.5, 381, 85, 0.5);
        escada1.registrarLeitura(leitura);
        escada1.registrarLeitura("15/10/2026 10:00", 2.0, 58, 25.0, 380, 84, 0.5);

        // escada 102: em atencao, abre manutencao programada
        escada2.registrarLeitura("15/10/2026 08:00", 3.9, 68, 27.0, 378, 55, 0.5);
        escada2.registrarLeitura("15/10/2026 10:00", 5.2, 74, 28.5, 376, 45, 0.49);

        // escada 201: piora de atencao para critico, abre manutencao programada e depois urgente
        escada3.registrarLeitura("15/10/2026 08:00", 6.0, 85, 31.0, 360, 50, 0.48);
        escada3.registrarLeitura("15/10/2026 10:00", 7.8, 96, 34.1, 349, 35, 0.46);

        // escada 301: critica por oleo baixo, abre manutencao urgente
        escada4.registrarLeitura("15/10/2026 10:00", 2.4, 60, 26.0, 384, 18, 0.5);

        System.out.println("===== LINHAS =====");
        System.out.println(linha4);
        System.out.println(linha5);

        System.out.println();
        System.out.println("===== ESTACOES =====");
        System.out.println(paulista);
        System.out.println(fariaLima);
        System.out.println(santoAmaro);

        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        equipamentos.add(escada1);
        equipamentos.add(escada2);
        equipamentos.add(escada3);
        equipamentos.add(escada4);

        System.out.println();
        System.out.println("===== ESCADAS ROLANTES =====");
        for (Equipamento equipamento : equipamentos) {
            equipamento.imprimirDados();
            System.out.println();
        }

        System.out.println("===== RESUMO DOS ALERTAS =====");
        for (Equipamento equipamento : equipamentos) {
            System.out.println(equipamento + " -> " + equipamento.calcularAlerta());
        }

        System.out.println();
        System.out.println("===== TESTE DE VALIDACAO =====");
        try {
            escada1.registrarLeitura("15/10/2026 11:00", 2.0, 58, 25.0, 380, 150, 0.5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
