package org.pemdas.game_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.BorderLayout;

public class TopScorersFrame extends JFrame{
    private JTable table;
    private PlayerService playerService;
    private JButton btnExit;

    public TopScorersFrame(Player currentPlayer) {
        playerService = new PlayerService();

        setLayout(new BorderLayout());

        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        ArrayList<Player> topPlayers = playerService.getTop5Players();

        for (Player p : topPlayers) {
            model.addRow(new Object[]{
                p.getUsername(),
                p.getWins(),
                p.getLosses(),
                p.getDraws(),
                p.getScore()
            });
        }

        table = new JTable(model);
        add(new JScrollPane(table));

        btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnExit);

        add(bottomPanel, BorderLayout.SOUTH);

        setTitle("Top Scorers");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
