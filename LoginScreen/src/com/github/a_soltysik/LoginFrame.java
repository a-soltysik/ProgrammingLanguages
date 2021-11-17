package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginFrame extends JFrame {
    public static final String TITLE = "Login screen";

    private final JTextField userField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);

    private final UserDataBase dataBase = new UserDataBase(true);

    public LoginFrame() {
        super(TITLE);
    }

    public void build() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(new LogInButton());
        buttonPanel.add(new CancelButton());

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        usernamePanel.setOpaque(false);
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(userField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.setOpaque(false);
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(passwordField);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setOpaque(false);
        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);

        getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        getContentPane().add(BorderLayout.CENTER, loginPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    conductLoginState();
                    System.out.println("aa");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
    }

    private void clearFields() {
        userField.setText("");
        passwordField.setText("");
    }

    private void conductLoginState() {
        if (dataBase.checkUser(userField.getText(), passwordField.getPassword())) {
            getContentPane().setBackground(Color.green);
        } else {
            getContentPane().setBackground(Color.red);
        }
    }

    private class LogInButton extends JButton {
        private static final String TEXT = "Login";

        public LogInButton() {
            super(TEXT);
            addActionListener(e -> conductLoginState());
        }
    }

    private class CancelButton extends  JButton {
        private static final String TEXT = "Cancel";

        public CancelButton() {
            super(TEXT);
            addActionListener(e -> clearFields());
        }
    }
}
