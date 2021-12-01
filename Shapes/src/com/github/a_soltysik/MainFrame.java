package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void init() {
        MainPanel panel = new MainPanel(500, 500);
        getContentPane().add(BorderLayout.CENTER, panel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();

        panel.setFocusable(true);
    }
}
