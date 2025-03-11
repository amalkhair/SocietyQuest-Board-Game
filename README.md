# SocietyQuest-Board-Game

A multiplayer interactive educational game with questions on society related issues. Enjoy!

Made as a startsemester first project for Fontys Hogescholen

---

# Society Quest - A Social Issues Board Game

**Society Quest** is a single-player, educational board game designed to raise awareness about key societal issues, such as climate change. In this game, you’ll answer questions related to various social topics. Answer correctly to move forward on the board, but get it wrong, and you'll stay in your current spot. If you answer incorrectly five times, you lose the game!

## Table of Contents
- [Overview](#overview)
- [Game Features](#game-features)
- [Technologies Used](#technologies-used)
- [How to Play](#how-to-play)
- [Running societyQuest as JAR](#running-societyquest-game-as-jar)
- [Building from source](#building-from-source)
- [Contributing](#contributing)
- [License](#license)

## Overview
In **Society Quest**, the goal is to answer a series of climate and social issue-related questions. Each time you answer a question correctly, you move forward on the board. Answer wrong, and you stay in the same spot. If you answer incorrectly five times, you lose the game! The objective is to make it to the last tile without running out of wrong attempts.

The game is built using **Java Swing** and provides a simple interface where you can interact with the game by pressing buttons to draw questions and track your progress.

## Game Features
- **Grid-based movement system**: The player moves through the board by answering questions correctly.
- **Interactive Question Cards**: Questions cover climate change and other societal issues.
- **Single-player mode**: Play solo and challenge your knowledge of important global topics.
- **Penalty system**: If you answer incorrectly five times, you lose the game.
- **Turn-based gameplay**: While it's a single-player game, you’ll be actively participating in each round.

## Technologies Used
- **Java Swing** for creating the graphical user interface (GUI).
- **Object-Oriented Programming (OOP)** principles to structure the game.

## How to Play
1. Click the **Start** button to begin the game.
2. Draw a question by clicking the **Draw Question** button.
3. Answer the multiple-choice question:
   - If you answer correctly, you move forward.
   - If you answer incorrectly, you stay in your current position.
4. Keep track of your incorrect answers—five wrong answers will make you lose the game.
5. The goal is to reach the final tile without hitting five wrong answers.
6. After the game, your charachter automatically returns to the start.

## Running SocietyQuest Game as JAR

SocietyQuest Game can be built as a fat JAR file that contains all its dependencies and can be run as stand-alone application. 

**Prerequisites**
- Java 23 or higher should be available
you can download the ready to use JAR file from the "Assets" section of the desired release from my GitHub releases page.

**Build**
- How this is done is independent of the artifact type you want to use and is documented in (#building-from-source)

**Run**
 ```bash
java -jar societyQuest-0.1.jar
 ```
## Building from source

To get the game up and running on your local machine, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/amalkhair/SocietyQuest-Board-Game.git
   ```
2. Navigate to the project directory:
   ```bash
   cd SocietyQuest-Board-Game
   ```
3. Compile and run the Java program:
   ```bash
   mvn clean install
   mvn exec:java
   ```

**Note**: Ensure you have Java installed on your system before running the program.

## Contributing
Contributions are welcome! If you'd like to improve the game or add new features, feel free to open a pull request or submit an issue.

## API DOCS
The API Documentation can be found [here](https://amalkhair.github.io/SocietyQuest-Board-Game/nl/amalin/fontys/game/Answer.html#constructor-detail)

### Steps to contribute:
1. Fork this repository.
2. Create a new branch.
3. Make your changes.
4. Push your changes and create a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

