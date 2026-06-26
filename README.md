# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Fikri Khairullah Kurniawan
Student ID: 5026251071
Class: A

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing. The application includes login, game statistics, and Top 5 scorer feature.

## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable
- 
## Database
Database used: PostgreSQL

## How to Run
1. Create the database.
2. Import schema.sql.
3. Open the Java project.
4. Configure DatabaseManager.java.
5. Run Main.java.
Note: No need to add JDBC driver. Driver is already provided in FP/pom.xml

## Class Explanation
Main: Starting point. Initiates the login frame.
DatabaseManager: Handles all connections to the database.
Player: Stores username, password, win count, lose count, draw count, and total score as one object.
PlayerService: The bridge between the program and DatabaseManager.
GameLogic: Stores methods for the game to run.
LoginFrame: GUI to login.
MainMenuFrame: GUI for main menu.
GameFrame: GUI to display the game.
StatisticsFrame: GUI to display personal statitistics.
TopScorersFrame: GUI to display top 5 players in the database.

## Screenshots


## Video Link
YouTube: https://youtu.be/Xn2RpJtNhVI
