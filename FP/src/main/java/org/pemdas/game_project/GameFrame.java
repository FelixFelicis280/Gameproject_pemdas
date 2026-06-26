package org.pemdas.game_project;

import javax.swing.*;
import java.awt.GridLayout;

public class GameFrame extends JFrame{
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        buttons = new JButton[9];
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            this.buttons[i] = new JButton("");
            add(buttons[i]);
        }

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
        }
    }

    private void handlePlayerMove(int index) {                
        if (!buttons[index].getText().isEmpty()) {
            return;
        }
        
        gameLogic.makeMove(index, 'X');
        buttons[index].setText("X");

        if (gameLogic.checkWinner('X')) {
            JOptionPane.showMessageDialog(this, "You win!");
            finishGame("WIN");
            return;
        }

        if (gameLogic.isDraw()) {
            JOptionPane.showMessageDialog(this, "Draw!");
            finishGame("DRAW");
            return;
        }

        int computerMove = gameLogic.computerMove();
        gameLogic.makeMove(computerMove, 'O');
        buttons[computerMove].setText("O");
        
        if (gameLogic.checkWinner('O')) {
            JOptionPane.showMessageDialog(this, "You lose!");
            finishGame("LOSE");
            return;
        }

        if (gameLogic.isDraw()) {
            JOptionPane.showMessageDialog(this, "Draw!");
            finishGame("DRAW");
            return;
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}
