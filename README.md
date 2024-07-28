# MagicalArena

This project is a simulation of a magical arena where two players fight until one of them loses all health.

## Features

- Turn-based combat system
- Players attack and defend using dice rolls
- Health, strength, and attack attributes determine combat outcomes
- Simple text-based interface

## Classes and Responsibilities
'Main'-
The Main class contains the main method to start the application.

'Arena'-
The Arena class handles the combat logic between two players.

'Player'-
The Player class represents a player in the game with attributes for health, strength, and attack.

'Dice'-
The Dice class simulates a dice roll.

The provided test cases cover a variety of scenarios for Player, Dice, and Arena. Here's a summary of what each test checks:

PlayerTest:

Creation and initial values.
Health reduction, including edge cases and negative damage.
Alive status based on health.

ArenaTest:

Validates that a match results in one player losing all health.
Ensures health reduction during the match.
Verifies that the player with lower health attacks first.
Tests a tie game scenario.
Custom dice rolling to test predictable outcomes.

These tests provide a good foundation to ensure your code is robust and behaves as expected in various scenarios.

## How to Run

1. Make sure you have Maven installed.
2. Navigate to the project directory.
3. Run the following command to execute the tests:

To run the unit tests, execute:
```sh
mvn test




