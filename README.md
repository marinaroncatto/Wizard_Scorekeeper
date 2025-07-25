# Wizard Scorekeeper (Em construção)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 

Um projeto pessoal desenvolvido em com o objetivo de automatizar o processo de apostas e contagem de pontos do jogo de cartas **Wizard**. Este sistema visa facilitar o gerenciamento da partida, economizando tempo dos jogadores e reduzindo erros manuais.

## Objetivo do Projeto

Automatizar:
- Registro de apostas de cada jogador por rodada
- Cálculo automático de pontuação com base no desempenho
- Geração de placar em tempo real

##  Regras Básicas do Jogo Wizard

**Wizard** é um jogo de cartas de previsão, jogado em várias rodadas. Em cada rodada:

1. Cada jogador recebe um número de cartas crescente (1 carta na primeira rodada, 2 na segunda, etc.).
2. Uma carta é virada do baralho para definir o naipe de trunfo da rodada (ou nenhuma, se for um especial).
3. Os jogadores fazem apostas sobre quantas "vazas" (ou "tricks") irão ganhar naquela rodada.
4. Jogadores então jogam as cartas uma a uma, seguindo regras de vazas.
5. Ao final da rodada, compara-se o número de vazas ganhas com a aposta feita.

##  Sistema de Pontuação

A pontuação de cada rodada funciona da seguinte maneira:

- **Acertou a aposta:**
  - +20 pontos fixos
  - +10 pontos por vaza feita
- **Errou a aposta:**
  - -10 pontos por diferença entre a aposta e o resultado real

### Exemplos:

| Aposta | Vazas Ganhadas | Pontos |
|--------|----------------|--------|
| 3      | 3              | 50     |
| 2      | 0              | -20    |
| 0      | 0              | 20     |
| 0      | 1              | -10    |

##  Como Rodar o Projeto

### Pré-requisitos

- Java 21 instalado

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
