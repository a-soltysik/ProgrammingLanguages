package com.github.a_soltysik;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().build());
    }
}
