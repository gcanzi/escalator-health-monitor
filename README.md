# Escalator Health Monitor

Projeto Java do Challenge Motiva (FIAP 2026/2027), disciplina Domain Driven Design.

O sistema registra as leituras dos sensores das escadas rolantes do metrô e abre uma manutenção automaticamente quando alguma leitura indica problema.

## Como funciona

Cada `Leitura` guarda os valores de vibração, temperatura, corrente, tensão, nível de óleo e velocidade. A partir deles, a leitura é classificada:

| Grandeza | Atenção | Crítico |
|---|---|---|
| Temperatura | acima de 70 °C | acima de 90 °C |
| Vibração | acima de 4,5 mm/s | acima de 7,1 mm/s |
| Nível de óleo | abaixo de 40% | abaixo de 20% |

Ao registrar uma leitura, a `EscadaRolante` abre uma manutenção:
- ATENÇÃO: manutenção PROGRAMADA
- CRÍTICO: manutenção URGENTE

Também é possível cadastrar manutenções PREVENTIVAS manualmente.

## Classes

- `Linha`: linha do metrô.
- `Estacao`: estação onde a escada está instalada.
- `Equipamento`: classe abstrata com id, fabricante e estação.
- `EscadaRolante`: classe principal, guarda as leituras e as manutenções.
- `Leitura`: valores dos sensores e cálculo do nível de alerta.
- `Manutencao`: data, descrição, técnico e tipo.
- `Main`: cria os objetos e imprime os dados.

## Como executar

Abra o projeto na IDE e execute a classe `Main`.