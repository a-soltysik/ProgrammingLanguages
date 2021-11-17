package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public static final String TITLE = "Ekran logowania";

    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private final LoginManager loginManager = new LoginManager();

    public LoginFrame() {
        super(TITLE);
    }

    public void build() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(new LoginButton());
        buttonPanel.add(new CancelButton());

        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridLayout(2, 2, 5, 5));
        loginPanel.add(new JLabel("Username:"), 0);
        loginPanel.add(userField, 1);
        loginPanel.add(new JLabel("Password:"), 2);
        loginPanel.add(passwordField, 3);

        getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        getContentPane().add(BorderLayout.CENTER, loginPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void clearFields() {
        userField.setText("");
        passwordField.setText("");
    }

    private void conductLoginState() {
        var state = loginManager.login(userField.getText(), passwordField.getPassword());
        switch (state) {
            case FAILURE -> getContentPane().setBackground(Color.red);
            case SUCCESS -> getContentPane().setBackground(Color.green);
        }
        System.out.println(getContentPane().getBackground().toString());
    }

    private class LoginButton extends JButton {
        private static final String TEXT = "Login";

        public LoginButton() {
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
