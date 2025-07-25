# Wizard Scorekeeper (in progress)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  

🌐 [Ler em português](README.md)

A personal project developed with the goal of automating the betting and scoring process of the **Wizard** card game. This system aims to simplify match management, saving players time and reducing manual errors.

## Project Goals

Automate:
- Recording of each player's bet per round
- Automatic score calculation based on performance
- Real-time scoreboard generation

## Basic Rules of the Wizard Card Game

**Wizard** is a trick-taking card game based on prediction, played over several rounds. In each round:

1. Each player receives an increasing number of cards (1 in the first round, 2 in the second, and so on).
2. A card is flipped from the deck to define the trump suit for the round (or none, if a special card is drawn).
3. Players place bets on how many tricks they expect to win that round.
4. Players then play their cards one by one, following trick rules.
5. At the end of the round, the number of tricks won is compared to each player's original bet.

## Scoring System

The scoring for each round works as follows:

- **Correct Bet:**
  - +20 fixed points
  - +10 points per trick won
- **Incorrect Bet:**
  - -10 points for each difference between the bet and actual result

### Examples:

| Bet | Tricks Won | Points |
|-----|------------|--------|
| 3   | 3          | 50     |
| 2   | 0          | -20    |
| 0   | 0          | 20     |
| 0   | 1          | -10    |

## How to Run the Project

### Prerequisites

- Java 21 installed
  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
