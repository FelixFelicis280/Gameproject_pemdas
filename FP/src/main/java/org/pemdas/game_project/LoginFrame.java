package org.pemdas.game_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private PlayerService playerService;
    private MainMenuFrame menuFrame;

    public LoginFrame() {
        playerService = new PlayerService();

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        txtUsername = new JTextField();
        txtUsername.setBounds(100, 20, 150, 25);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 150, 25);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 100, 100, 25);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 80, 25);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 60, 80, 25);

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                Player player = playerService.login(username, password);

                if (player != null) {
                    dispose();

                    menuFrame = new MainMenuFrame(player);
                    menuFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(
                        LoginFrame.this,
                        "Invalid username or password"
                    );

                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            }
        });
    }
        
}
