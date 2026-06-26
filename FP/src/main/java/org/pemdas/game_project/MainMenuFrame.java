package org.pemdas.game_project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class MainMenuFrame extends JFrame{
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;
    private JLabel lblWelcome;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player;
        
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        lblWelcome = new JLabel(
            "Welcome, " + currentPlayer.getUsername(),
            SwingConstants.CENTER
        );

        btnStartGame = new JButton("Start Game");
        btnStatistics = new JButton("Statistics");
        btnTopScorers = new JButton("Top Scorers");
        btnExit = new JButton("Exit");

        add(lblWelcome);
        add(btnStartGame);
        add(btnStatistics);
        add(btnTopScorers);
        add(btnExit);

        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });

        btnStatistics.addActionListener(e -> {
            StatisticsFrame statisticsFrame = new StatisticsFrame(currentPlayer);
            statisticsFrame.setVisible(true);
            this.dispose();
        });

        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame(currentPlayer);
            topFrame.setVisible(true);
            this.dispose();
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }
}
