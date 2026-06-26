package org.pemdas.game_project;

import javax.swing.*;
import java.awt.GridLayout;

public class StatisticsFrame extends JFrame{
    private JLabel lblTitle;
    private JLabel lblWins;
    private JLabel lblLosses;
    private JLabel lblDraws;
    private JLabel lblScore;
    private JButton btnExit;

    public StatisticsFrame(Player currentPlayer){
        setTitle(currentPlayer.getUsername() + "'s Statistics");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));
    
        lblTitle = new JLabel(
            currentPlayer.getUsername() + "'s Statistics",
            SwingConstants.CENTER
        );
    
        lblWins = new JLabel(
            "Wins: " + currentPlayer.getWins(),
            SwingConstants.CENTER
        );
    
        lblLosses = new JLabel(
            "Losses: " + currentPlayer.getLosses(),
            SwingConstants.CENTER
        );
    
        lblDraws = new JLabel(
            "Draws: " + currentPlayer.getDraws(),
            SwingConstants.CENTER
        );
    
        lblScore = new JLabel(
            "Total Score: " + currentPlayer.getScore(),
            SwingConstants.CENTER
        );

        btnExit = new JButton("Exit");

        add(lblTitle);
        add(lblWins);
        add(lblLosses);
        add(lblDraws);
        add(lblScore);
        add(btnExit);

        btnExit.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });
    }
}
